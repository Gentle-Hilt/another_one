package gentle.hilt.product.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.data.R

@Composable
fun QuestionMarkIcon(modifier: Modifier){
    Box(
        modifier = modifier
            .size(24.dp)
            .background(Color(0XFFDEDEDE), shape = CircleShape)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.question_mark),
            contentDescription = null,
            tint = MaterialTheme.themeColors.contrastText,
            modifier = Modifier.fillMaxSize().padding(2.dp)
        )
    }
}