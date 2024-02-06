package gentle.hilt.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import gentle.hilt.login.screen.TermsOfLoyalty
import gentle.hilt.login.screen.TopBar
import gentle.hilt.login.screen.buttons.LoginButton
import gentle.hilt.login.screen.buttons.PhoneNumber
import gentle.hilt.login.screen.buttons.SurName
import gentle.hilt.login.screen.buttons.UserName


@Composable
fun LoginScreen() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {
        val (topBar, username, surname, phoneNumber, loginButton, termsText) = createRefs()

        TopBar(
            modifier = Modifier.constrainAs(topBar) {
                top.linkTo(parent.top)
            })


        UserName(modifier = Modifier.constrainAs(username) {
            top.linkTo(topBar.bottom, margin = 116.dp)
            centerHorizontallyTo(parent)

            width = Dimension.fillToConstraints
            height = Dimension.value(66.dp)
        })


        SurName(
            modifier = Modifier.constrainAs(surname) {
                top.linkTo(username.bottom, margin = 16.dp)
                centerHorizontallyTo(parent)

                height = Dimension.value(66.dp)
                width = Dimension.fillToConstraints
            },
        )

        PhoneNumber(
            modifier = Modifier.constrainAs(phoneNumber) {
                top.linkTo(surname.bottom, margin = 16.dp)
                centerHorizontallyTo(parent)

                width = Dimension.fillToConstraints
                height = Dimension.value(66.dp)
            }
        )


        LoginButton(
            modifier = Modifier.constrainAs(loginButton) {
                top.linkTo(phoneNumber.bottom, margin = 16.dp)
                centerHorizontallyTo(parent)

                height = Dimension.value(51.dp)
            })


        TermsOfLoyalty(
            modifier = Modifier.constrainAs(termsText) {

                centerHorizontallyTo(parent)
                bottom.linkTo(parent.bottom, margin = 10.dp)
            })

    }
}
