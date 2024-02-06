package gentle.hilt.data.screens_logic.profile_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun temporaryPluralFormFavorite(favorite: Int?): String {
    return remember{when (favorite) {
        0, null -> "товаров"
        1 -> "товар"
        in 2..4 -> "товара"
        else -> "товаров"
    }}
}