package gentle.hilt.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import gentle.hilt.catalog.screen.CatalogList
import gentle.hilt.catalog.screen.FilterButton
import gentle.hilt.catalog.screen.SortButton
import gentle.hilt.catalog.screen.TagsBar
import gentle.hilt.catalog.screen.TopBar
import gentle.hilt.data.screens_logic.catalog_screen.SortOption
import gentle.hilt.data.screens_logic.catalog_screen.remember.rememberExtractingTags
import gentle.hilt.data.screens_logic.catalog_screen.remember.rememberFilteringCatalog
import org.koin.androidx.compose.getViewModel
import org.koin.core.component.KoinComponent


class CatalogScreen : Screen, KoinComponent {

    override val key: ScreenKey = uniqueScreenKey



    @Composable
    override fun Content() {
        val viewModel: CatalogScreenVM = getViewModel()
        val catalogState = viewModel.catalogState.collectAsStateWithLifecycle()

        var selectedTags by remember { mutableStateOf<List<String>>(emptyList()) }
        var sortOption by remember { mutableStateOf(SortOption.Popularity) }
        var isExpanded by remember { mutableStateOf(false) }

        val tagsList = rememberExtractingTags(catalogState = catalogState.value)
        val filteredCatalog = rememberFilteringCatalog(selectedTags, catalogState.value, sortOption)

        ConstraintLayout(
            Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            val (catalog, tags, sorting, filter, topBar) = createRefs()


            TopBar(
                modifier = Modifier.constrainAs(topBar){
                top.linkTo(parent.top)
            })

            SortButton(
                onSortSelected = { newSortOption ->
                    sortOption = newSortOption
                },
                isExpanded = isExpanded,
                toggle = { isExpanded = !isExpanded },
                selectedSortOption = sortOption,
                modifier = Modifier.constrainAs(sorting) {
                    top.linkTo(topBar.bottom, margin = 20.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
            )

            FilterButton(modifier = Modifier.constrainAs(filter) {
                top.linkTo(sorting.top)
                end.linkTo(parent.end, margin = 16.dp)
                bottom.linkTo(sorting.bottom)

            })

            TagsBar(
                tags = tagsList,
                selectedTags = selectedTags,
                modifier = Modifier.constrainAs(tags) {
                    top.linkTo(sorting.bottom)
                    centerHorizontallyTo(parent)

                }
            ) { newTags ->
                selectedTags = newTags
            }


            CatalogList(
                catalog = filteredCatalog,
                modifier = Modifier.constrainAs(catalog) {
                    top.linkTo(tags.bottom, margin = 32.dp)

                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                    bottom.linkTo(parent.bottom)

                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                })



        }

    }
}