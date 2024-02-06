package gentle.hilt.data.screens_logic.login_screen.outlined_text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import gentle.hilt.data.res.themes.themeColors

@Composable
fun textFieldColors(): TextFieldColors {
    return TextFieldDefaults.textFieldColors(
        textColor = MaterialTheme.themeColors.text,
        disabledTextColor = Color.Transparent,
        backgroundColor = MaterialTheme.themeColors.unselected,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        unfocusedLabelColor = MaterialTheme.themeColors.fadeIcons,
        focusedLabelColor = Color.Transparent,
        cursorColor = MaterialTheme.themeColors.text,
    )
}