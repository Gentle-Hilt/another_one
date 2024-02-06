package gentle.hilt.login.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import gentle.hilt.data.res.font.FontSizes
import gentle.hilt.data.res.font.Fonts
import gentle.hilt.data.res.text_style.captionOneStyle
import gentle.hilt.data.res.themes.themeColors


@Composable
fun TermsOfLoyalty(modifier: Modifier) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            style = captionOneStyle,
            color = MaterialTheme.themeColors.fadeIcons,
            text = "Нажимая кнопку “Войти”, Вы принимаете "
        )

        Text(
            fontFamily = Fonts.sf_pro_display,
            fontWeight = FontWeight.Normal,
            fontSize = FontSizes.LINK.sp,
            color = MaterialTheme.themeColors.fadeIcons,
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                    append("условия программы лояльности")
                }
            })
    }

}