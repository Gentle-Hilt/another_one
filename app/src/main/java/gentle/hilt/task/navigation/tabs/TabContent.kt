package gentle.hilt.task.navigation.tabs

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.transitions.SlideTransition

@Composable
fun Tab.TabContent(screen: Screen) {
    Navigator(screen) { navigator ->
        SlideTransition(navigator)
    }
}

@Composable
fun listOfTabs(): MutableMap<String, Tab> {
    return mutableMapOf(
        HomeTab.options.title to HomeTab,
        CatalogTab.options.title to CatalogTab,
        BinTab.options.title to BinTab,
        PromotionTab.options.title to PromotionTab,
        ProfileTab.options.title to ProfileTab
    )
}
