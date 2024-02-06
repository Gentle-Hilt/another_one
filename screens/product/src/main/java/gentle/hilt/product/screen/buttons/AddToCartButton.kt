package gentle.hilt.product.screen.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import gentle.hilt.data.res.painters.drawhelpers.size
import gentle.hilt.data.res.text_style.buttonSecondStyle
import gentle.hilt.data.res.text_style.captionOneStyle
import gentle.hilt.data.res.themes.themeColors

@Composable
fun AddToCartButton(actual: String?, old: String?, modifier: Modifier) {
    Button(colors = ButtonDefaults.buttonColors(MaterialTheme.themeColors.buttonColor),onClick = { }, modifier = modifier.clip(RoundedCornerShape(8.dp))) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$actual" + "₽",
                    style = buttonSecondStyle,
                    color = MaterialTheme.themeColors.contrastText
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "$old" + "₽",
                    color = Color(0xFFFF8AC9),
                    style = captionOneStyle,
                    modifier = modifier.drawWithContent {
                        drawContent()
                        drawLine(
                            color = Color(0xFFFF8AC9),
                            strokeWidth = 1f,
                            cap = StrokeCap.Round,
                            start = Offset(size(1f), size(40f)),
                            end = Offset(size(100f), size(25f))
                        )
                    }
                )
            }

            Text(
                text = "Добавить корзину",
                style = buttonSecondStyle,
                color = MaterialTheme.themeColors.contrastText
            )
        }



    }

}