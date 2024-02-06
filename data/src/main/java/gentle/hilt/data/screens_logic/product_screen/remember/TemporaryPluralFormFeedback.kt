package gentle.hilt.data.screens_logic.product_screen.remember

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun temporaryPluralFormFeedback(feedbackCount: Int?): String {
    return remember{when (feedbackCount) {
        0, null -> "отзывов"
        1 -> "отзыв"
        in 2..4 -> "отзыва"
        else -> "отзывов"
    }}
}