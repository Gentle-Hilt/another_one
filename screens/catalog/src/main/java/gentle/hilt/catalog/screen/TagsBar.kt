package gentle.hilt.catalog.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gentle.hilt.data.res.font.FontSizes
import gentle.hilt.data.res.font.Fonts
import gentle.hilt.data.res.text_style.buttonSecondStyle
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.data.screens_logic.catalog_screen.remember.temporaryTranslationTags


@Composable
fun TagsBar(
    tags: List<String>,
    selectedTags: List<String>,
    modifier: Modifier,
    onTagSelected: (List<String>) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        TagItem(
            tag = "Смотреть все",
            isSelected = selectedTags.isEmpty(),
            onClick = { onTagSelected(emptyList()) },
            showClearIcon = false
        )

        tags.distinct().forEach { tag ->
            TagItem(
                tag = temporaryTranslationTags(tag),
                isSelected = selectedTags.contains(tag),
                onClick = {
                    val newTags = if (selectedTags.contains(tag)) {
                        selectedTags - tag
                    } else {
                        listOf(tag)
                    }
                    onTagSelected(newTags)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun TagItem(tag: String, isSelected: Boolean, onClick: () -> Unit, showClearIcon: Boolean = true) {
    Card(
        backgroundColor = if (isSelected) MaterialTheme.themeColors.selected else MaterialTheme.themeColors.unselected,
        shape = RoundedCornerShape(100.dp),
        onClick = onClick,
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = tag,
                color = if (isSelected) MaterialTheme.themeColors.contrastText else MaterialTheme.themeColors.fadeIcons,
                style = buttonSecondStyle,
            )

            if (isSelected && showClearIcon) {
                Icon(
                    imageVector = Icons.Filled.Clear,
                    contentDescription = null,
                    tint = MaterialTheme.themeColors.contrastText,
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .size(20.dp)
                        .clickable { onClick() }
                )
            }
        }
    }
}