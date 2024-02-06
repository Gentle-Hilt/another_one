package gentle.hilt.catalog.screen.catalog_item.references.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import gentle.hilt.data.res.text_style.captionOneStyle
import gentle.hilt.data.res.themes.themeColors


@Composable
fun Subtitle(
    description: String?,
    modifier: Modifier
) {
    Text(
        textAlign = TextAlign.Start ,
        style = captionOneStyle,
        color = MaterialTheme.themeColors.bottomNavigation,
        minLines = 3,
        maxLines = 3,
        text = description ?: "",
        modifier = modifier
    )
}