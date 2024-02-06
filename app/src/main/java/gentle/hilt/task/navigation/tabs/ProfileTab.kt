package gentle.hilt.task.navigation.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import gentle.hilt.profile.ProfileScreen

object ProfileTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            return remember {
                TabOptions(
                    index = 0u,
                    title = "Профиль"
                )
            }
        }

    @Composable
    override fun Content() {
        TabContent(screen = ProfileScreen())
    }
}
