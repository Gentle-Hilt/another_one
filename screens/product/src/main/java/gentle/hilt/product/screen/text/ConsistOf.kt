package gentle.hilt.product.screen.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import gentle.hilt.data.res.text_style.titleOneStyle
import gentle.hilt.data.res.themes.themeColors

@Composable
fun ConsistOf(isExtended :Boolean, consistOf: String, modifier: Modifier){

        Text(
            text = consistOf,
            color = MaterialTheme.themeColors.text,
            style = titleOneStyle,
            maxLines = if (isExtended) /*Int.Max_Value*/ 20 else 2,
            overflow = TextOverflow.Ellipsis,
            modifier = modifier
        )

}
