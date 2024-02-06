package gentle.hilt.product.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImagePager(
    painters: List<Painter>,
    pagerState: PagerState,
    modifier: Modifier
) {
    HorizontalPager(
        state = pagerState,
        modifier = modifier
    ) { page ->
        Image(
            painter = painters[page],
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}
