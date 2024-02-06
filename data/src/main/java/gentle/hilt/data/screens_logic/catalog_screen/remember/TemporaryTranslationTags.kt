package gentle.hilt.data.screens_logic.catalog_screen.remember

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember


@Composable
fun temporaryTranslationTags(tag: String): String {
    return remember{ when (tag) {
        "body" -> "Тело"
        "mask" -> "Маска"
        "face" -> "Лицо"
        "suntan" -> "Загар"
        else -> tag
    }}
}
