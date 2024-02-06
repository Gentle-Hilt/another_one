package gentle.hilt.favorite.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gentle.hilt.data.room.catalog.CatalogItemEntity
import gentle.hilt.favorite.screen.favorite_item.FavoriteItem

@Composable
fun FavoriteList(favorites: List<CatalogItemEntity?>, modifier: Modifier){

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        verticalArrangement = Arrangement.spacedBy(7.dp),
        modifier = modifier) {
        items(favorites){ catalogEntity->
            catalogEntity?.let {
                FavoriteItem(catalog = it)
            }

        }
    }
}