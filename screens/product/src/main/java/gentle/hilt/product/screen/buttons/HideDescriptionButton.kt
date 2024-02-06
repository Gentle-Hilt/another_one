package gentle.hilt.product.screen.buttons

import androidx.compose.foundation.clickable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import gentle.hilt.data.res.text_style.buttonFirstStyle
import gentle.hilt.data.res.themes.themeColors

@Composable
fun HideDescriptionButton(
    isVisible: Boolean,
    onClick: () -> Unit,
    modifier: Modifier,
) {
    Text(
        modifier =  modifier.clickable {
            onClick()
        },
        text = if(isVisible) "Скрыть" else "Подробнее",
        color = MaterialTheme.themeColors.fadeIcons,
        style = buttonFirstStyle,
    )
}