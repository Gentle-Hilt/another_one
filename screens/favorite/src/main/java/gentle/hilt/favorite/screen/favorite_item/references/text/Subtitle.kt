package gentle.hilt.favorite.screen.favorite_item.references.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import gentle.hilt.data.res.text_style.captionOneStyle


@Composable
fun Subtitle(
    description: String?,
    modifier: Modifier
) {
    Text(
        textAlign = TextAlign.Start ,
        style = captionOneStyle,
        minLines = 3,
        maxLines = 3,
        text = description ?: "",
        modifier = modifier
    )
}