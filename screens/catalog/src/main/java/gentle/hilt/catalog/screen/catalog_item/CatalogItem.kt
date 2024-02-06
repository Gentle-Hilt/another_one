package gentle.hilt.catalog.screen.catalog_item

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import gentle.hilt.catalog.screen.catalog_item.references.text.ActualPrice
import gentle.hilt.catalog.screen.catalog_item.references.buttons.AddToCartButton
import gentle.hilt.catalog.screen.catalog_item.references.text.DiscountPercentage
import gentle.hilt.catalog.screen.catalog_item.references.buttons.FavoriteButton
import gentle.hilt.catalog.screen.catalog_item.references.ImageDots
import gentle.hilt.catalog.screen.catalog_item.references.ImagePager
import gentle.hilt.catalog.screen.catalog_item.references.text.OldPrice
import gentle.hilt.catalog.screen.catalog_item.references.text.RatingWithAmount
import gentle.hilt.catalog.screen.catalog_item.references.text.Subtitle
import gentle.hilt.catalog.screen.catalog_item.references.text.Title
import gentle.hilt.data.datastore.CatalogImages
import gentle.hilt.data.room.catalog.CatalogItemEntity
import gentle.hilt.navigation.SharedScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CatalogItem(
    catalog: CatalogItemEntity,
    navigator: Navigator = LocalNavigator.currentOrThrow,
) {
    val coroutineScope = rememberCoroutineScope()

    val mappedCatalogImages = remember(catalog.id) {
        CatalogImages.imageMapping[catalog.id]?.map { it } ?: emptyList()
    }
    val listOfPainters = mappedCatalogImages.map { painterResource(id = it) }
    val pagerState = rememberPagerState(pageCount = { mappedCatalogImages.size })

    val productScreen = ScreenRegistry.get(SharedScreen.ProductScreen(catalog))

    ConstraintLayout(
        modifier = Modifier
            .width(168.dp)
            .height(287.dp)
            .padding(start = 6.dp, end = 6.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                navigator.push(productScreen)
            }

    ) {
        val (actualPrice, discount, favorite, add, imageDots, imagePager, title, ratingWithAmount, description, oldPrice) = createRefs()

        ImagePager(
            painters = listOfPainters,
            pagerState = pagerState,
            modifier = Modifier.constrainAs(imagePager) {
                top.linkTo(parent.top)
                centerHorizontallyTo(parent)

                height = Dimension.value(144.dp)
                width = Dimension.fillToConstraints
            }
        )

        ImageDots(
            onImageSelected = { selectedImageIndex ->
                coroutineScope.launch { pagerState.animateScrollToPage(selectedImageIndex) }
            },
            totalImages = mappedCatalogImages.size,
            selectedImage = pagerState.currentPage,
            modifier = Modifier.constrainAs(imageDots) {
                top.linkTo(imagePager.bottom, margin = (-5).dp)
                centerHorizontallyTo(parent)
            }
        )


        FavoriteButton(
            catalog = catalog,
            modifier = Modifier.constrainAs(favorite) {
                top.linkTo(parent.top, margin = 6.dp)
                end.linkTo(parent.end)

                height = Dimension.value(24.dp)
                width = Dimension.value(24.dp)
            }
        )

        OldPrice(catalog.oldPrice, modifier = Modifier.constrainAs(oldPrice) {
            top.linkTo(imagePager.bottom, margin = 3.dp)
            start.linkTo(parent.start)
        })

        ActualPrice(catalog.newPrice, modifier = Modifier.constrainAs(actualPrice) {
            top.linkTo(oldPrice.bottom, margin = 2.dp)
            start.linkTo(parent.start)
        })

        DiscountPercentage(catalog.discountPercentage, modifier = Modifier.constrainAs(discount) {
            start.linkTo(actualPrice.end, margin = 8.dp)
            top.linkTo(actualPrice.top)
            bottom.linkTo(actualPrice.bottom)

            width = Dimension.value(34.dp)
            height = Dimension.value(14.dp)
        })

        Title(
            catalog.title,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(actualPrice.bottom, margin = 2.dp)
                start.linkTo(parent.start)
            })


        Subtitle(
            catalog.subtitle, modifier = Modifier.constrainAs(description) {
                bottom.linkTo(ratingWithAmount.top, margin = 10.dp)
                top.linkTo(title.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            })

        RatingWithAmount(
            rating = catalog.rating,
            amount = catalog.available,
            modifier = Modifier.constrainAs(ratingWithAmount) {
                bottom.linkTo(add.top, margin = -(10).dp)
                start.linkTo(parent.start)

            })


        AddToCartButton(
            modifier = Modifier.constrainAs(add) {
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)

                height = Dimension.value(32.dp)
                width = Dimension.value(32.dp)
            }
        )

    }
}

