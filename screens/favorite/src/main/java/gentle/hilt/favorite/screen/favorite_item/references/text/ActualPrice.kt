package gentle.hilt.favorite.screen.favorite_item.references.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import gentle.hilt.data.res.text_style.titleSecondStyle

@Composable
fun ActualPrice(price: String?, modifier: Modifier){
    Text(
        text = "$price" + "₽" ,
        style = titleSecondStyle,
        modifier = modifier
    )
}