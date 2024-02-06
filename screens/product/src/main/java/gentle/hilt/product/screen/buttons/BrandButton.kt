package gentle.hilt.product.screen.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import gentle.hilt.data.R
import gentle.hilt.data.res.text_style.titleSecondStyle
import gentle.hilt.data.res.themes.themeColors


@Composable
fun BrandButton(title: String, modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(color = MaterialTheme.themeColors.unselected)
            .clip(RoundedCornerShape(8.dp))
            .clickable { }
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 9.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                color = MaterialTheme.themeColors.fadeIcons,
                style = titleSecondStyle,
                textAlign = TextAlign.Start
            )

            Icon(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = "",
                modifier = Modifier.size(32.dp)
            )
        }


    }

}