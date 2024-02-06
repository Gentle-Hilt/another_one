package gentle.hilt.product.screen.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import gentle.hilt.data.res.text_style.titleOneStyle
import gentle.hilt.data.res.themes.themeColors

@Composable
fun Title(title: String?, modifier: Modifier){
    Text(
        text = title ?: "",
        color = MaterialTheme.themeColors.fadeIcons,
        style = titleOneStyle,
        modifier = modifier
    )
}
