package gentle.hilt.product.screen.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import gentle.hilt.data.res.font.FontSizes
import gentle.hilt.data.res.font.Fonts

@Composable
fun Subtitle(
    description: String?,
    modifier: Modifier
) {
    Text(

        textAlign = TextAlign.Start,
        fontFamily = Fonts.sf_pro_display,
        fontSize = FontSizes.LARGE_TITLE_ONE.sp,
        fontWeight = FontWeight.Medium,
        maxLines = 3,
        text = description ?: "",
        modifier = modifier
    )
}