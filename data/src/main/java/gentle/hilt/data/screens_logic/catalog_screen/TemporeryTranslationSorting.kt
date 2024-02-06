package gentle.hilt.data.screens_logic.catalog_screen

import androidx.compose.runtime.Composable

@Composable
fun temporaryTranslationSorting(sortOption: SortOption): String {
    return when (sortOption) {
        SortOption.Popularity -> "По популярности"
        SortOption.PriceDescending -> "По убыванию"
        SortOption.PriceAscending -> "По возрастанию"
    }
}

