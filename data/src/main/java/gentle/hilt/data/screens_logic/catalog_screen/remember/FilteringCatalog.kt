package gentle.hilt.data.screens_logic.catalog_screen.remember

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import gentle.hilt.data.room.catalog.CatalogItemEntity
import gentle.hilt.data.screens_logic.catalog_screen.SortOption


@Composable
fun rememberFilteringCatalog(
    selectedTags: List<String>,
    catalogState: List<CatalogItemEntity?>,
    sortOption: SortOption
): List<CatalogItemEntity> {
    return remember(selectedTags, catalogState, sortOption) {
        val filteredList = catalogState.filterNotNull().filter { catalogItem ->
            selectedTags.isEmpty() || catalogItem.tags.any { it in selectedTags } == true
        }

        when (sortOption) {
            SortOption.Popularity -> filteredList.sortedByDescending { it.rating }
            SortOption.PriceDescending -> filteredList.sortedByDescending { it.newPrice.toDoubleOrNull() }
            SortOption.PriceAscending -> filteredList.sortedBy { it.newPrice.toDoubleOrNull() }
        }
    }
}