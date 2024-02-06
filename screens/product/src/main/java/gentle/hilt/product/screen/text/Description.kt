package gentle.hilt.product.screen.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import gentle.hilt.data.res.text_style.textOneStyle
import gentle.hilt.data.res.themes.themeColors

@Composable
fun Description(description: String?, modifier: Modifier) {

    Text(
        text = description ?: "",
        color = MaterialTheme.themeColors.bottomNavigation,
        style = textOneStyle,
        modifier = modifier
    )


}