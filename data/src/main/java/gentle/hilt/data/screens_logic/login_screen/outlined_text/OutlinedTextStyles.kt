package gentle.hilt.data.screens_logic.login_screen.outlined_text

import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import gentle.hilt.data.res.font.FontSizes
import gentle.hilt.data.res.font.Fonts
import gentle.hilt.data.res.themes.themeColors


@Composable
fun textOutlinedStyle(): TextStyle {
    return LocalTextStyle.current.copy(
        color = MaterialTheme.themeColors.text,
        fontSize = FontSizes.PLACE_HOLDER.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = Fonts.sf_pro_display
    )
}
