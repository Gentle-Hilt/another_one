package gentle.hilt.login.screen.buttons

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import gentle.hilt.data.res.font.Fonts
import gentle.hilt.data.res.text_style.buttonSecondStyle
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.login.LoginScreenVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel


@Composable
fun LoginButton(
    modifier: Modifier,
    coroutineScope :CoroutineScope= rememberCoroutineScope(),
    vm: LoginScreenVM = getViewModel(),
    context: Context = LocalContext.current
){
    val isActive = vm.isUsernameValid && vm.isSurnameValid && vm.isPhoneNumberValid

    Button(
        modifier = modifier.fillMaxWidth().clip(RoundedCornerShape(8.dp)),
        colors = if (isActive) ButtonDefaults.buttonColors(MaterialTheme.themeColors.buttonColor) else ButtonDefaults.buttonColors(Color(0xFFFF8AC9)),
        onClick = {
            if (isActive) {
                coroutineScope.launch { vm.loginUser() }
            } else {
                Toast.makeText(context, "Заполните поля!", Toast.LENGTH_SHORT).show()
            }
        },
        enabled = true,
    ) {
        Text(
            color = MaterialTheme.themeColors.contrastText,
            text = "Войти",
            style = buttonSecondStyle,
            fontFamily = Fonts.sf_pro_display,
        )
    }
}