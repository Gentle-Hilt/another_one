package gentle.hilt.data.screens_logic.product_screen.remember

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import gentle.hilt.data.R

@Composable
fun starPainterChooser(index: Int, rating: Double): Int {
    return remember {
        when {
            index < rating.toInt() -> R.drawable.star_filled
            index == rating.toInt() && rating % 1 > 0.1 -> R.drawable.half_star
            else -> R.drawable.empty_star
        }
    }
}
