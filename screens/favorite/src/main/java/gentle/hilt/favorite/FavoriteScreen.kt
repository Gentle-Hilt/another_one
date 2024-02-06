package gentle.hilt.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import gentle.hilt.data.screens_logic.SharedFavoriteVM
import gentle.hilt.favorite.screen.BrandsOrProductsButton
import gentle.hilt.favorite.screen.FavoriteList
import gentle.hilt.favorite.screen.TopBar
import kotlinx.parcelize.IgnoredOnParcel
import org.koin.androidx.compose.getViewModel
import org.koin.core.component.KoinComponent


class FavoriteScreen : Screen, KoinComponent {

    @IgnoredOnParcel
    override val key: ScreenKey = uniqueScreenKey


    @Composable
    override fun Content() {
        val viewModel: SharedFavoriteVM = getViewModel()
        val favoritesState = viewModel.catalogState.collectAsStateWithLifecycle()

        var toggleButton by remember { mutableStateOf(true) }

        ConstraintLayout(
            Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(start = 16.dp, end = 16.dp)
        ) {
            val (topBar, favorites, toggle) = createRefs()


            TopBar(modifier = Modifier.constrainAs(topBar) {
                top.linkTo(parent.top)

                width = Dimension.fillToConstraints
                height = Dimension.value(49.dp)
            })

            BrandsOrProductsButton(
                toggleButton = toggleButton,
                onToggle = { toggleButton = !toggleButton },
                modifier = Modifier.constrainAs(toggle) {
                    top.linkTo(topBar.bottom, margin = 24.dp)

                    height = Dimension.value(49.dp)
                    width = Dimension.fillToConstraints
                }
            )

            if (toggleButton){
                FavoriteList(
                    favorites = favoritesState.value,
                    modifier = Modifier.constrainAs(favorites) {
                        top.linkTo(toggle.bottom, margin = 24.dp)

                        centerHorizontallyTo(parent)
                        bottom.linkTo(parent.bottom)

                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints

                    })
            }

        }

    }
}
