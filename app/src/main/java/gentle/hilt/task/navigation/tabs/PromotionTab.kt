package gentle.hilt.task.navigation.tabs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

object PromotionTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            return remember {
                TabOptions(
                    index = 0u,
                    title = "Акции"
                )
            }
        }

    @Composable
    override fun Content() {
        TabContent(screen = FakeScreen())
    }
}
