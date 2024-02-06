package gentle.hilt.product.screen.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gentle.hilt.data.res.painters.drawhelpers.size
import gentle.hilt.data.res.font.FontSizes
import gentle.hilt.data.res.font.Fonts
import gentle.hilt.data.res.text_style.elementStyle
import gentle.hilt.data.res.text_style.textOneStyle
import gentle.hilt.data.res.themes.themeColors


@Composable
fun PriceWithDiscountAndOldPrice(actual :String?, old:String?, discount: Int? ,modifier: Modifier){
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$actual" + "₽",
            fontFamily = Fonts.sf_pro_display,
            fontSize = FontSizes.PRICE.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.themeColors.fadeIcons
        )
        Spacer(modifier = Modifier.width(11.dp))
        Text(
            text = "$old" + "₽",
            color = MaterialTheme.themeColors.fadeIcons,
            style = textOneStyle,
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
        Spacer(modifier = Modifier.width(11.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(width = 34.dp, height = 16.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.themeColors.buttonColor)
        ) {
            Text(
                color = MaterialTheme.themeColors.contrastText,
                text = "$discount%",
                style = elementStyle,
            )
        }
    }
}