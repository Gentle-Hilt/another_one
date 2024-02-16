package gentle.hilt.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gentle.hilt.data.room.user.UserEntity
import gentle.hilt.data.room.user.interactions.GetUserFromDb
import gentle.hilt.data.room.user.interactions.ObserveUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SingleActivityVM(
    private val getUserFromDb: GetUserFromDb,
    private val observeUser: ObserveUser
) : ViewModel() {

    private val _userState = MutableStateFlow<UserEntity?>(null)
    val userState: StateFlow<UserEntity?> = _userState

    init {
        checkUser()
    }

    private fun checkUser() {
        viewModelScope.launch {
            // Prevents LoginScreen flickering
            _userState.value = getUserFromDb.getUser()

            observeUser.observeUser().collectLatest { user ->
                _userState.value = user
            }
        }
    }
}
