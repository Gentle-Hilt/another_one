package gentle.hilt.task.navigation.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

object BinTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            return remember {
                TabOptions(
                    index = 0u,
                    title = "Корзина"
                )
            }
        }

    @Composable
    override fun Content() {
        TabContent(screen = FakeScreen())
    }
}
