package gentle.hilt.catalog.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import gentle.hilt.data.R
import gentle.hilt.data.res.text_style.titleFourStyle
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.data.screens_logic.catalog_screen.SortOption
import gentle.hilt.data.screens_logic.catalog_screen.temporaryTranslationSorting

@Composable
fun SortButton(
    selectedSortOption: SortOption,
    onSortSelected: (SortOption) -> Unit,
    isExpanded: Boolean,
    toggle: () -> Unit,
    modifier: Modifier,
) {

    Box(
        modifier = modifier
            .clickable { toggle() }
    ) {

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.height(24.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_up_and_down),
                contentDescription = "",
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.themeColors.text
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = temporaryTranslationSorting(sortOption = selectedSortOption),
                style = titleFourStyle,
                color = MaterialTheme.themeColors.bottomNavigation
            )

            Icon(
                painter = painterResource(id = R.drawable.small_arrow_down),
                contentDescription = "",
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.themeColors.text
            )
        }

        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { toggle() }
        ) {
            SortOption.entries.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        onSortSelected(option)
                        toggle()
                    }
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(text = temporaryTranslationSorting(option))
                    }
                }
            }
        }
    }
}
