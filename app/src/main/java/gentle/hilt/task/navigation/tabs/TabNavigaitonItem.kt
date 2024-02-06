package gentle.hilt.task.navigation.tabs

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.LocalAndroidTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import gentle.hilt.data.res.text_style.captionOneStyle
import gentle.hilt.data.res.themes.themeColors

@Composable
fun RowScope.TabNavigationItem(
    tab: Tab,
    painter: Painter
) {
    val tabNavigator = LocalAndroidTabNavigator.current
    val currentTabTitle = tabNavigator.current.options.title
    val isSelected = tabNavigator.current.key == tab.key

    BottomNavigationItem(
        selectedContentColor = MaterialTheme.themeColors.buttonColor,
        unselectedContentColor = MaterialTheme.themeColors.bottomNavigation,
        label = {
            Text(
                maxLines = 1,
                text = tab.options.title,
                style = captionOneStyle
            )
        },
        selected = isSelected,
        onClick = {
            if (tabNavigator.current != tab) {
                tabNavigator.updateTabHistory(currentTabTitle)
                tabNavigator.current = tab
            }
        },
        icon = {
            Icon(
                painter = painter,
                contentDescription = currentTabTitle,
                modifier = Modifier
                    .size(width = 32.dp, height = 40.dp)
            )
        }
    )
}
