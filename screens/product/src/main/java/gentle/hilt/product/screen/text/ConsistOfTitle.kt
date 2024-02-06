package gentle.hilt.product.screen.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import gentle.hilt.data.res.text_style.titleOneStyle
import gentle.hilt.data.res.themes.themeColors

@Composable
fun ConsistOfTitle(modifier: Modifier){
    Text(
        text = "Состав",
        color = MaterialTheme.themeColors.text,
        style = titleOneStyle,
        modifier = modifier
    )
}
