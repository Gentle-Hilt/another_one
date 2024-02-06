package gentle.hilt.favorite.screen.favorite_item.references.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import gentle.hilt.data.res.text_style.elementStyle
import gentle.hilt.data.res.themes.themeColors

@Composable
fun DiscountPercentage(discount: Int?, modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.themeColors.buttonColor)
    ) {
        Text(
            color = MaterialTheme.themeColors.contrastText,
            text = "$discount%",
            style = elementStyle
        )
    }

}