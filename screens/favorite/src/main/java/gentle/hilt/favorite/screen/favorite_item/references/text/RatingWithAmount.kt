package gentle.hilt.favorite.screen.favorite_item.references.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import gentle.hilt.data.R
import gentle.hilt.data.res.text_style.elementStyle
import gentle.hilt.data.res.themes.themeColors


@Composable
fun RatingWithAmount(rating: Double, amount: Int, modifier: Modifier) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier.size(14.dp),
            painter = painterResource(id = R.drawable.star_filled),
            contentDescription = "",
            tint = MaterialTheme.themeColors.stars
        )

        Spacer(Modifier.width(4.dp))

        Text(
            text = "$rating",
            style = elementStyle,
            color = MaterialTheme.themeColors.stars,

        )

        Spacer(modifier = Modifier.width(2.dp))

        Text(
            text = "($amount)",
            color = MaterialTheme.themeColors.fadeIcons,
            style = elementStyle,
        )
    }


}