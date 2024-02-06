package gentle.hilt.product

import cafe.adriel.voyager.core.registry.screenModule
import gentle.hilt.navigation.SharedScreen

val productScreen = screenModule {
    register<SharedScreen.ProductScreen> { provider ->
        ProductScreen(product = provider.product)
    }
}