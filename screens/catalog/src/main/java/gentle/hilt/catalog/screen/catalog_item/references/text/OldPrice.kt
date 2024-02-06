package gentle.hilt.catalog.screen.catalog_item.references.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import gentle.hilt.data.res.painters.drawhelpers.size
import gentle.hilt.data.res.text_style.elementStyle
import gentle.hilt.data.res.themes.themeColors


@Composable
fun OldPrice(oldPrice: String?, modifier: Modifier) {

    Text(
        text = "$oldPrice" + "₽",
        color = MaterialTheme.themeColors.fadeIcons,
        style = elementStyle,
        modifier = modifier.drawWithContent {
            drawContent()
            drawLine(
                color = Color(0XFFA0A1A3),
                strokeWidth = 1f,
                cap = StrokeCap.Round,
                start = Offset(size(1f), size(40f)),
                end = Offset(size(100f), size(25f))
            )
        }
    )
}