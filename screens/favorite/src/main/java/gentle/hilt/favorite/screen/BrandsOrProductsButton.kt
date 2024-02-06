package gentle.hilt.favorite.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import gentle.hilt.data.res.text_style.titleFourStyle
import gentle.hilt.data.res.themes.themeColors

@Composable
fun BrandsOrProductsButton(toggleButton: Boolean, onToggle: () -> Unit, modifier: Modifier) {
    Box(modifier = modifier.background(MaterialTheme.themeColors.contrastText)) {
        Row(
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            repeat(2) { index ->
                val isToggleButton = index == 0 == toggleButton
                val buttonText = if (index == 0) "Товары" else "Бренды"

                Button(
                    elevation = ButtonDefaults.elevation(0.dp),
                    modifier = Modifier
                        .weight(0.5f)
                        .clip(RoundedCornerShape(8.dp)),
                    colors = if (isToggleButton) ButtonDefaults.buttonColors(MaterialTheme.themeColors.contrastText) else ButtonDefaults.buttonColors(MaterialTheme.themeColors.unselected),
                    onClick = {
                        onToggle()
                    }
                ) {
                    Box(
                        Modifier,
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = buttonText,
                            color = if (isToggleButton) MaterialTheme.themeColors.text else MaterialTheme.themeColors.fadeIcons,
                            style = titleFourStyle,
                        )
                    }
                }
            }
        }
    }
}