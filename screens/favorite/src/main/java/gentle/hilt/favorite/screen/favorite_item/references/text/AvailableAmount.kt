package gentle.hilt.favorite.screen.favorite_item.references.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import gentle.hilt.data.res.font.Fonts
import gentle.hilt.data.res.themes.themeColors


@Composable
fun AvailableAmount(amount:Int, modifier: Modifier){
    Text(
        text = "($amount)",
        color = MaterialTheme.themeColors.fadeIcons,
        fontSize = 9.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = Fonts.sf_pro_display,
        modifier = modifier
    )

}