package gentle.hilt.profile.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import gentle.hilt.data.R
import gentle.hilt.data.res.text_style.captionOneStyle
import gentle.hilt.data.res.text_style.titleSecondStyle
import gentle.hilt.data.res.themes.themeColors


@Composable
fun UserProfileData(
    userName: String?,
    userSurname: String?,
    userPhone: String?,
    modifier: Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(color = MaterialTheme.themeColors.unselected)

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp)
                )

                Column {
                    Text(
                        text = "$userName $userSurname",
                        color = MaterialTheme.themeColors.text,
                        style = titleSecondStyle,
                        textAlign = TextAlign.Start
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "$userPhone",
                        color = MaterialTheme.themeColors.fadeIcons,
                        style = captionOneStyle,
                        textAlign = TextAlign.Start
                    )
                }
            }


            Icon(
                painter = painterResource(id = R.drawable.logout),
                contentDescription = "",
                modifier = Modifier
                    .size(24.dp)
                    .clickable {

                    }
            )
        }


    }

}