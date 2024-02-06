package gentle.hilt.favorite.screen.favorite_item.references

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gentle.hilt.data.res.themes.themeColors

@Composable
fun ImageDots(
    totalImages: Int,
    selectedImage: Int,
    onImageSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(totalImages) { page ->
            Box(
                modifier = Modifier
                    .size(4.dp)
                    .clickable { onImageSelected(page) }
                    .background(
                        color = if (page == selectedImage) MaterialTheme.themeColors.buttonColor else MaterialTheme.themeColors.fadeIcons,
                        shape = CircleShape
                    )
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}

