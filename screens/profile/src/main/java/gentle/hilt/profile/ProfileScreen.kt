package gentle.hilt.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import gentle.hilt.profile.screen.FeedBack
import gentle.hilt.profile.screen.LogOutButton
import gentle.hilt.profile.screen.Offer
import gentle.hilt.profile.screen.OtherShops
import gentle.hilt.profile.screen.ReturnProduct
import gentle.hilt.profile.screen.TopBar
import gentle.hilt.profile.screen.UserFavorite
import gentle.hilt.profile.screen.UserProfileData
import kotlinx.parcelize.IgnoredOnParcel
import org.koin.androidx.compose.getViewModel
import org.koin.core.component.KoinComponent


class ProfileScreen : Screen, KoinComponent {

    @IgnoredOnParcel
    override val key: ScreenKey = uniqueScreenKey


    @Composable
    override fun Content() {
        val viewModel: ProfileScreenVM = getViewModel()
        val user by viewModel.userState.collectAsStateWithLifecycle()


        ConstraintLayout(
            Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(start = 16.dp, end = 16.dp)
        ) {
            val (topBar, userData, userFavorite, otherShops, feedBack, offer, returnProduct, logOut) = createRefs()


            TopBar(modifier = Modifier.constrainAs(topBar) {
                top.linkTo(parent.top)

                width = Dimension.fillToConstraints
                height = Dimension.value(49.dp)

            })


            UserProfileData(
                userName = user?.username,
                userSurname = user?.surname,
                userPhone = user?.phoneNumber,
                modifier = Modifier.constrainAs(userData) {
                    top.linkTo(topBar.bottom, margin = 24.dp)

                    width = Dimension.fillToConstraints
                    height = Dimension.value(49.dp)

                })

            UserFavorite(modifier = Modifier.constrainAs(userFavorite) {
                top.linkTo(userData.bottom, margin = 26.dp)

                width = Dimension.fillToConstraints
                height = Dimension.value(49.dp)

            })

            OtherShops(modifier = Modifier.constrainAs(otherShops) {
                top.linkTo(userFavorite.bottom, margin = 8.dp)

                width = Dimension.fillToConstraints
                height = Dimension.value(49.dp)

            })

            FeedBack(modifier = Modifier.constrainAs(feedBack) {
                top.linkTo(otherShops.bottom, margin = 8.dp)

                width = Dimension.fillToConstraints
                height = Dimension.value(49.dp)

            })

            Offer(Modifier.constrainAs(offer) {
                top.linkTo(feedBack.bottom, margin = 8.dp)

                width = Dimension.fillToConstraints
                height = Dimension.value(49.dp)

            })

            ReturnProduct(Modifier.constrainAs(returnProduct) {
                top.linkTo(offer.bottom, margin = 8.dp)

                width = Dimension.fillToConstraints
                height = Dimension.value(49.dp)

            })

            LogOutButton(
                user = user,
                Modifier.constrainAs(logOut) {
                    bottom.linkTo(parent.bottom, margin = 32.dp)

                    width = Dimension.fillToConstraints
                    height = Dimension.value(51.dp)

                })


        }

    }
}
