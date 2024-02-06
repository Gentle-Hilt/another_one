package gentle.hilt.product.screen.buttons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import gentle.hilt.data.R

@Composable
fun CopyInformationButton(modifier: Modifier) {
    Icon(
        painter = painterResource(id = R.drawable.copy_button), contentDescription = "",
        modifier = modifier.size(24.dp).clickable {  }
    )

}