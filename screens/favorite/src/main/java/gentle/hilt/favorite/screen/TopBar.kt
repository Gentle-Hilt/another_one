package gentle.hilt.favorite.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import gentle.hilt.data.R
import gentle.hilt.data.datastore.MagicNumbers
import gentle.hilt.data.res.text_style.titleOneStyle
import gentle.hilt.data.res.themes.themeColors

@Composable
fun TopBar(
    modifier: Modifier,
    navigator: Navigator = LocalNavigator.currentOrThrow

) {
    TopAppBar(
        elevation = 0.dp,
        modifier = modifier.height(MagicNumbers.TOP_BAR_HEIGHT.dp),
        backgroundColor = MaterialTheme.themeColors.contrastText,
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(start = 5.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = "",
                tint = MaterialTheme.themeColors.text,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        navigator.pop()
                    }
            )
            
            Spacer(modifier = Modifier.width(28.dp))

            Text(
                text = "Избранное",
                color = MaterialTheme.themeColors.text,
                style = titleOneStyle,
                modifier = modifier
            )
        }
    }
}