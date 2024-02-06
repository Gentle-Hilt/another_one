package gentle.hilt.data.screens_logic.catalog_screen.remember

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import gentle.hilt.data.room.catalog.CatalogItemEntity

@Composable
fun rememberExtractingTags(catalogState: List<CatalogItemEntity?>): List<String> {
    return remember(catalogState) {
        catalogState.flatMap { catalogItem ->
            catalogItem?.tags.orEmpty().filterNotNull()
        }.distinct()
    }
}