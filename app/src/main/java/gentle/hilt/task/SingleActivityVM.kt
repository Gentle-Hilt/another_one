package gentle.hilt.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gentle.hilt.data.room.user.UserEntity
import gentle.hilt.data.room.user.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SingleActivityVM(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _userState = MutableStateFlow<UserEntity?>(null)
    val userState: StateFlow<UserEntity?> = _userState

    init {
        checkUser()
    }

    private fun checkUser() {
        viewModelScope.launch {
            // Prevents LoginScreen flickering
            _userState.value = userRepository.getUser()

            userRepository.observedUser.collectLatest { user ->
                _userState.value = user
            }
        }
    }
}
