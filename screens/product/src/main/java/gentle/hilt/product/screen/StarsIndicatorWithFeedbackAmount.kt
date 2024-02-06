package gentle.hilt.product.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import gentle.hilt.data.res.text_style.elementStyle
import gentle.hilt.data.res.text_style.textOneStyle
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.data.screens_logic.product_screen.remember.starPainterChooser
import gentle.hilt.data.screens_logic.product_screen.remember.temporaryPluralFormFeedback

@Composable
fun StarsIndicatorWithFeedbackAmount(rating: Double, feedbackCount: Int, modifier: Modifier = Modifier) {
    if (rating > 0.0 && feedbackCount > 0) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(5) { index ->
                Icon(
                    painter = painterResource(id = starPainterChooser(index, rating)),
                    modifier = Modifier.size(14.dp),
                    contentDescription = "",
                    tint = MaterialTheme.themeColors.stars
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = rating.toString(),
                style = elementStyle,
                color = MaterialTheme.themeColors.fadeIcons
            )
            Spacer(modifier = Modifier.width(6.dp))
            Box(
                modifier = Modifier
                    .size(2.dp)
                    .background(MaterialTheme.themeColors.fadeIcons, shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "$feedbackCount ${temporaryPluralFormFeedback(feedbackCount = feedbackCount)}",
                style = textOneStyle,
                color = MaterialTheme.themeColors.fadeIcons
            )
        }

    }
}