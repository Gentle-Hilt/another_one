package gentle.hilt.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider
import gentle.hilt.data.room.catalog.CatalogItemEntity


sealed class SharedScreen : ScreenProvider {
    data object FavoriteScreen: SharedScreen()
    data class ProductScreen(val product: CatalogItemEntity) : SharedScreen()
}

