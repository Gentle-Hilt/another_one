package gentle.hilt.product.screen.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import gentle.hilt.data.res.text_style.textOneStyle
import gentle.hilt.data.res.themes.themeColors

@Composable
fun AvailableAmount(amount:Int, modifier: Modifier){
    Text(
        text = "Доступно для заказа $amount штук",
        color = MaterialTheme.themeColors.fadeIcons,
        style = textOneStyle,
        modifier = modifier
    )

}