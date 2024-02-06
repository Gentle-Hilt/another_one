package gentle.hilt.task.navigation.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import org.koin.core.component.KoinComponent

class FakeScreen : Screen, KoinComponent {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        ConstraintLayout(
            Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(start = 16.dp, end = 16.dp)
        ) {
            val (title) = createRefs()

            Text(
                color = Color.Black,
                text = "Fake screen",
                modifier = Modifier.constrainAs(title) {
                    centerVerticallyTo(parent)
                    centerHorizontallyTo(parent)
                }
            )
        }
    }
}
