package gentle.hilt.task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import gentle.hilt.login.LoginScreen
import gentle.hilt.task.navigation.AppNavigation
import gentle.hilt.task.theme_selector.ProvideThemes
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SingleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ProvideThemes {
                val viewModel: SingleActivityVM = getViewModel()
                val userUser by viewModel.userState.collectAsState()

                if (userUser != null) {
                    AppNavigation()
                } else {
                    LoginScreen()
                }
            }
        }
    }
}
