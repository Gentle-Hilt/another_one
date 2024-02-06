package gentle.hilt.catalog.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import gentle.hilt.data.R
import gentle.hilt.data.res.text_style.titleFourStyle
import gentle.hilt.data.res.themes.themeColors


@Composable
fun FilterButton(modifier:Modifier){
    Box(
        modifier = modifier
            .clickable {  }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.height(24.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.filters),
                contentDescription = "",
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.themeColors.text
            )

            Text(
                text = "Фильтры",
                style = titleFourStyle,
                color = MaterialTheme.themeColors.bottomNavigation
            )

        }

    }

}