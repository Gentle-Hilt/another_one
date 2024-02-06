package gentle.hilt.favorite

import cafe.adriel.voyager.core.registry.screenModule
import gentle.hilt.navigation.SharedScreen

val favoriteScreen = screenModule {
    register<SharedScreen.FavoriteScreen> {
        FavoriteScreen()
    }
}