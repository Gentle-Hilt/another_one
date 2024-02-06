package gentle.hilt.task.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.AndroidTabDisposable
import cafe.adriel.voyager.navigator.tab.AndroidTabNavigator
import cafe.adriel.voyager.navigator.tab.CurrentAndroidTab
import gentle.hilt.data.R
import gentle.hilt.data.datastore.MagicNumbers.BOTTOM_NAVIGATION_HEIGHT
import gentle.hilt.data.res.themes.NoRippleEffectTheme
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.task.navigation.tabs.BinTab
import gentle.hilt.task.navigation.tabs.CatalogTab
import gentle.hilt.task.navigation.tabs.HomeTab
import gentle.hilt.task.navigation.tabs.ProfileTab
import gentle.hilt.task.navigation.tabs.PromotionTab
import gentle.hilt.task.navigation.tabs.TabNavigationItem
import gentle.hilt.task.navigation.tabs.listOfTabs

@Composable
fun AppNavigation() {
    AndroidTabNavigator(
        initialTab = CatalogTab,
        titlesToTabs = listOfTabs(),
        noBackStackGoToThePreviousTab = true,
        tabDisposable = { androidTabNavigator ->
            AndroidTabDisposable(
                tabNavigator = androidTabNavigator,
                tabs = listOf(HomeTab, CatalogTab, BinTab, ProfileTab, ProfileTab)
            )
        }
    ) {
        Scaffold(
            content = { padding ->
                Box(Modifier.padding(padding)) {
                    CurrentAndroidTab()
                }
            },
            bottomBar = {
                CompositionLocalProvider(LocalRippleTheme provides NoRippleEffectTheme) {
                    Surface {
                        BottomNavigation(
                            modifier = Modifier.height(BOTTOM_NAVIGATION_HEIGHT.dp),
                            backgroundColor = MaterialTheme.themeColors.contrastText
                        ) {
                            TabNavigationItem(HomeTab, painterResource(id = R.drawable.home))
                            TabNavigationItem(CatalogTab, painterResource(id = R.drawable.catalog))
                            TabNavigationItem(BinTab, painterResource(id = R.drawable.bin))
                            TabNavigationItem(PromotionTab, painterResource(id = R.drawable.promotion))
                            TabNavigationItem(ProfileTab, painterResource(id = R.drawable.profile))
                        }
                    }
                }
            }
        )
    }
}
