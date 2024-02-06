package gentle.hilt.catalog.screen.catalog_item.references.buttons

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import gentle.hilt.data.res.painters.drawhelpers.size
import gentle.hilt.data.res.themes.themeColors


@Composable
fun AddToCartButton(modifier: Modifier){
    val lineColors = MaterialTheme.themeColors.contrastText
    Box(modifier = modifier
        .clip(shape = RoundedCornerShape(topStart = 8.dp, bottomEnd = 8.dp))
        .background(MaterialTheme.themeColors.buttonColor),
        contentAlignment = Alignment.Center
    ){

        Canvas(modifier = Modifier.fillMaxSize()) {
            drawLine(
                color = lineColors,
                strokeWidth = 3f,
                cap = StrokeCap.Round,
                start = Offset(size(25f),size(50f)),
                end =  Offset(size(75f),size(50f))
            )
            drawLine(
                color = lineColors,
                strokeWidth = 3f,
                cap = StrokeCap.Round,
                start = Offset(size(50f),size(25f)),
                end =  Offset(size(50f),size(75f))
            )
        }

    }

}