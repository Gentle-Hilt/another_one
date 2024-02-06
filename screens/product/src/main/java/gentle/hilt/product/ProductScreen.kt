package gentle.hilt.product

import android.os.Parcelable
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import gentle.hilt.data.datastore.CatalogImages
import gentle.hilt.data.room.catalog.CatalogItemEntity
import gentle.hilt.product.screen.dynamic_constraints.dynamicHideButtonConstraints
import gentle.hilt.product.screen.dynamic_constraints.dynamicPriceConstraints
import gentle.hilt.product.screen.buttons.AddToCartButton
import gentle.hilt.product.screen.text.AvailableAmount
import gentle.hilt.product.screen.buttons.BrandButton
import gentle.hilt.product.screen.text.Characteristics
import gentle.hilt.product.screen.text.CharacteristicsTitle
import gentle.hilt.product.screen.text.ConsistOf
import gentle.hilt.product.screen.text.ConsistOfTitle
import gentle.hilt.product.screen.buttons.CopyInformationButton
import gentle.hilt.product.screen.text.Description
import gentle.hilt.product.screen.text.DescriptionTitle
import gentle.hilt.product.screen.buttons.FavoriteButton
import gentle.hilt.product.screen.buttons.HideConsistOfButton
import gentle.hilt.product.screen.buttons.HideDescriptionButton
import gentle.hilt.product.screen.ImageDots
import gentle.hilt.product.screen.ImagePager
import gentle.hilt.product.screen.text.PriceWithDiscountAndOldPrice
import gentle.hilt.product.screen.QuestionMarkIcon
import gentle.hilt.product.screen.StarsIndicatorWithFeedbackAmount
import gentle.hilt.product.screen.text.Subtitle
import gentle.hilt.product.screen.text.Title
import gentle.hilt.product.screen.TopBar
import kotlinx.coroutines.launch
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import org.koin.core.component.KoinComponent

@Parcelize
data class ProductScreen(val product: CatalogItemEntity) : Screen, Parcelable, KoinComponent {

    @IgnoredOnParcel
    override val key: ScreenKey = uniqueScreenKey


    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    override fun Content() {
        val coroutineScope = rememberCoroutineScope()
        ProductLifecycle(this@ProductScreen)

        val mappedCatalogImages = remember(product) {
            CatalogImages.imageMapping[product.id]?.map { it } ?: emptyList()
        }
        val listOfPainters = mappedCatalogImages.map { painterResource(id = it) }
        val pagerState = rememberPagerState(pageCount = { mappedCatalogImages.size })

        var hidDescription by remember { mutableStateOf(false) }
        var hidConsistOf by remember { mutableStateOf(false) }

        val scrollState = rememberScrollState()


        ConstraintLayout(
            Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .background(Color.White)
                .padding(start = 16.dp, end = 16.dp)
        ) {
            val (imagePager, imageDots, title, hideDescription, subtitle, brandButton, description, availableAmount, stars, prices, descriptionTitle, charTitle, charActual, consistOfTitle, copy, consistOf) = createRefs()
            val (hideConsistOf, addToCartButton, favorite, questionMark, topBar) = createRefs()

            TopBar(
                modifier = Modifier.constrainAs(topBar){
                    top.linkTo(parent.top)

                    width = Dimension.fillToConstraints
                })

            ImagePager(
                painters = listOfPainters,
                pagerState = pagerState,
                modifier = Modifier.constrainAs(imagePager) {
                    top.linkTo(topBar.bottom, margin = 16.dp)
                    centerHorizontallyTo(parent)

                    width = Dimension.fillToConstraints
                    height = Dimension.value(368.dp)
                })

            FavoriteButton(
                product = product,
                modifier = Modifier.constrainAs(favorite) {
                top.linkTo(imagePager.top)
                end.linkTo(imagePager.end, margin = 2.dp)
            })

            QuestionMarkIcon(modifier = Modifier.constrainAs(questionMark) {
                bottom.linkTo(imagePager.bottom, margin = 16.dp)
                start.linkTo(imagePager.start)
            })



            ImageDots(
                onImageSelected = { selectedImageIndex ->
                    coroutineScope.launch { pagerState.animateScrollToPage(selectedImageIndex) }
                },
                totalImages = mappedCatalogImages.size,
                selectedImage = pagerState.currentPage,
                modifier = Modifier.constrainAs(imageDots) {
                    top.linkTo(imagePager.bottom)
                    centerHorizontallyTo(parent)
                }
            )

            Title(
                product.title,
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(imageDots.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                })

            Subtitle(
                product.subtitle, modifier = Modifier.constrainAs(subtitle) {
                    top.linkTo(title.bottom, margin = 8.dp)

                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                    width = Dimension.fillToConstraints

                })

            AvailableAmount(
                product.available, modifier = Modifier.constrainAs(availableAmount) {
                    top.linkTo(subtitle.bottom, margin = 10.dp)
                })


            StarsIndicatorWithFeedbackAmount(
                product.rating,
                product.feedBackCount,
                modifier = Modifier.constrainAs(stars) {
                    top.linkTo(availableAmount.bottom, margin = 20.dp)
                }
            )

            PriceWithDiscountAndOldPrice(
                actual = product.newPrice,
                old = product.oldPrice,
                discount = product.discountPercentage,
                modifier = Modifier.constrainAs(prices) {
                    top.linkTo(
                        dynamicPriceConstraints(product, stars.bottom, availableAmount.bottom),
                        margin = 16.dp
                    )
                }
            )

            DescriptionTitle(modifier = Modifier.constrainAs(descriptionTitle) {
                top.linkTo(prices.bottom, margin = 24.dp)
            })

            if (hidDescription) {
                BrandButton(
                    title = product.title,
                    modifier = Modifier.constrainAs(brandButton) {
                        top.linkTo(descriptionTitle.bottom, margin = 16.dp)

                        height = Dimension.value(48.dp)
                        width = Dimension.fillToConstraints
                    })

                Description(
                    description = product.description,
                    modifier = Modifier.constrainAs(description) {
                        top.linkTo(brandButton.bottom, margin = 8.dp)
                    })
            }

            HideDescriptionButton(
                isVisible = hidDescription,
                onClick = {
                    hidDescription = !hidDescription
                    if (hidDescription) coroutineScope.launch { scrollState.animateScrollTo(500) }
                },

                modifier = Modifier.constrainAs(hideDescription) {
                    top.linkTo(
                        dynamicHideButtonConstraints(
                            hidDescription,
                            descriptionTitle.bottom,
                            description.bottom
                        ), margin = 10.dp
                    )
                })

            CharacteristicsTitle(modifier = Modifier.constrainAs(charTitle) {
                top.linkTo(hideDescription.bottom, margin = 34.dp)
            })


            Characteristics(product.info, modifier = Modifier.constrainAs(charActual) {
                top.linkTo(charTitle.bottom, margin = 26.dp)
            })


            ConsistOfTitle(modifier = Modifier.constrainAs(consistOfTitle) {
                top.linkTo(charActual.bottom, margin = 34.dp)
            })

            CopyInformationButton(modifier = Modifier.constrainAs(copy) {
                top.linkTo(consistOfTitle.top)
                end.linkTo(parent.end)
                bottom.linkTo(consistOfTitle.bottom)
            })

            ConsistOf(isExtended = hidConsistOf, product.consistOf, modifier = Modifier.constrainAs(consistOf) {
                top.linkTo(consistOfTitle.bottom, margin = 16.dp)
            })

            HideConsistOfButton(
                isVisible = hidConsistOf,
                onClick = {
                    hidConsistOf = !hidConsistOf
                    if (hidConsistOf) coroutineScope.launch { scrollState.animateScrollTo(1500) }
                },

                modifier = Modifier.constrainAs(hideConsistOf) {
                    top.linkTo(consistOf.bottom, margin = 10.dp)
                })

            AddToCartButton(product.newPrice, product.oldPrice, modifier = Modifier.constrainAs(addToCartButton) {
                top.linkTo(hideConsistOf.bottom, margin = 32.dp)
                centerHorizontallyTo(parent)

                height = Dimension.value(51.dp)
                width = Dimension.fillToConstraints
            })


        }

    }
}
