package gentle.hilt.catalog.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gentle.hilt.catalog.screen.catalog_item.CatalogItem
import gentle.hilt.data.room.catalog.CatalogItemEntity

@Composable
fun CatalogList(catalog: List<CatalogItemEntity?>, modifier: Modifier){

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        verticalArrangement = Arrangement.spacedBy(7.dp),
        modifier = modifier) {
        items(catalog){ catalogEntity->
            catalogEntity?.let {
                CatalogItem(catalog = it)
            }

        }
    }
}