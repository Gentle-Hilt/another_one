package gentle.hilt.product

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.screen.Screen
import timber.log.Timber

@Composable
fun ProductLifecycle(
    Screen: Screen,
){

    Screen.LifecycleEffect(
        onStarted = { Timber.d("Start product screen") },
        onDisposed = { Timber.d("Dispose product screen") }
    )

}