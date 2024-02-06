package gentle.hilt.product.screen.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gentle.hilt.data.res.text_style.textOneStyle
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.network.models.goods.Info


@Composable
fun Characteristics(info: List<Info?>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        info.forEachIndexed { index, characteristic ->
            if (characteristic != null) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = if (index == 0) 0.dp else 16.dp, bottom = 3.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = characteristic.title ?: "",
                        color = MaterialTheme.themeColors.bottomNavigation,
                        style = textOneStyle,
                    )
                    Text(
                        text = characteristic.value ?: "",
                        color = MaterialTheme.themeColors.bottomNavigation,
                        style = textOneStyle
                    )

                }

                Divider(
                    color = MaterialTheme.themeColors.fadeIcons,
                    thickness = 1.dp,
                    modifier = Modifier
                )
            }
        }
    }
}