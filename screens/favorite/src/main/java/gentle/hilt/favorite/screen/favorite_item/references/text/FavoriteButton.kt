package gentle.hilt.favorite.screen.favorite_item.references.text

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import gentle.hilt.data.R
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.data.room.catalog.CatalogItemEntity
import gentle.hilt.data.screens_logic.SharedFavoriteVM
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel


@Composable
fun FavoriteButton(
    catalog: CatalogItemEntity,
    viewModel: SharedFavoriteVM = getViewModel(),
    modifier: Modifier
) {
    val coroutineScope = rememberCoroutineScope()
    val isFavorite by viewModel.isFavorite(catalog).collectAsState(initial = false)

    Icon(
        tint = MaterialTheme.themeColors.buttonColor,
        painter = if (isFavorite) painterResource(id = R.drawable.filled_favorite) else painterResource(id = R.drawable.outlined_favorite),
        contentDescription = "",
        modifier = modifier
            .size(24.dp)
            .clickable {
                coroutineScope.launch {
                    if (isFavorite) {
                        viewModel.deleteCatalogEntity(catalog)
                    } else {
                        viewModel.saveCatalogEntity(catalog)
                    }
                }
            }
    )
}