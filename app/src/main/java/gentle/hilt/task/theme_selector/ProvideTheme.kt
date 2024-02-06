package gentle.hilt.task.theme_selector

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import gentle.hilt.data.res.colors.LocalColors
import gentle.hilt.data.res.themes.default.defaultThemeLight

@Composable
fun ProvideThemes(
    content: @Composable () -> Unit
) {
    // The same way we could provide strings
    // example from my previous project https://github.com/Gentle-Hilt/Absolute/blob/master/data/src/main/java/gentle/hilt/data/res/strings/Strings.kt
    CompositionLocalProvider(LocalColors provides defaultThemeLight) {
        MaterialTheme {
            content()
        }
    }
}
