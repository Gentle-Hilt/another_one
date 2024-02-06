package gentle.hilt.catalog.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gentle.hilt.data.datastore.MagicNumbers
import gentle.hilt.data.res.text_style.titleOneStyle
import gentle.hilt.data.res.themes.themeColors

@Composable
fun TopBar(modifier: Modifier){

    TopAppBar(
        elevation = 0.dp,
        modifier = modifier.height(MagicNumbers.TOP_BAR_HEIGHT.dp),
        title = {
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Каталог",
                    color = MaterialTheme.themeColors.text,
                    style = titleOneStyle,
                    modifier = modifier
                )
            }
        },
        backgroundColor = MaterialTheme.themeColors.contrastText,
    )

}