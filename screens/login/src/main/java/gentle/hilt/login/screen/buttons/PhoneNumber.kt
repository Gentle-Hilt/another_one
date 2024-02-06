package gentle.hilt.login.screen.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import gentle.hilt.data.res.text_style.placeHolderStyle
import gentle.hilt.data.res.themes.themeColors
import gentle.hilt.data.screens_logic.login_screen.PhoneMask
import gentle.hilt.data.screens_logic.login_screen.outlined_text.customTextSelectionColors
import gentle.hilt.data.screens_logic.login_screen.outlined_text.textFieldColors
import gentle.hilt.data.screens_logic.login_screen.outlined_text.textOutlinedStyle
import gentle.hilt.login.LoginScreenVM
import org.koin.androidx.compose.getViewModel


@Composable
fun PhoneNumber(
    modifier: Modifier,
    vm: LoginScreenVM = getViewModel()
) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = modifier
            .background(MaterialTheme.themeColors.unselected)
            .padding(start = 16.dp, end = 16.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {

        CompositionLocalProvider(LocalTextSelectionColors provides customTextSelectionColors) {
            TextField(
                colors = textFieldColors(),
                textStyle = textOutlinedStyle(),
                value = vm.phoneState,
                onValueChange = { newValue ->
                    vm.phoneState = newValue.take(PhoneMask.MASK.count { char -> char == PhoneMask.CHAR_FOR_MASK })
                    if (newValue.length == 1 && (newValue.first() == '7' || newValue.first() == '+' || newValue.first() == '-')) {
                        vm.phoneState = ""
                    }
                    vm.observePhone()
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                visualTransformation = PhoneMask.phoneNumberMask,
                label = {
                    if (vm.phoneState.isEmpty()) {
                        Text(
                            text = "Номер Телефона",
                            style = placeHolderStyle,
                        )
                    }

                },
                modifier = Modifier.fillMaxWidth(),
            )
        }
        if (vm.phoneState.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterEnd)
                    .clickable { vm.phoneState = "" }
            ) {
                Icon(
                    modifier = Modifier.fillMaxSize(),
                    imageVector = Icons.Default.Clear,
                    contentDescription = null,
                    tint = MaterialTheme.themeColors.text
                )
            }
        }
    }
}

