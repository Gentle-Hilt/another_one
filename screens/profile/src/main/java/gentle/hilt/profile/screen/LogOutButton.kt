package gentle.hilt.profile.screen


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import gentle.hilt.data.res.text_style.titleSecondStyle
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.data.room.user.UserEntity
import gentle.hilt.profile.ProfileScreenVM
import org.koin.androidx.compose.getViewModel


@Composable
fun LogOutButton(
    user: UserEntity?,
    modifier: Modifier,
    viewModel: ProfileScreenVM = getViewModel()
) {

    Button(
        onClick = { user?.let { viewModel.deleteUser(user) } },
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.themeColors.unselected),
        modifier = modifier,
        elevation = ButtonDefaults.elevation(0.dp)
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(),

        ){
            Text(
                text = "Выйти",
                color = MaterialTheme.themeColors.text,
                style = titleSecondStyle,
                textAlign = TextAlign.Start
            )
        }


    }

}