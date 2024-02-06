package gentle.hilt.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gentle.hilt.data.room.user.UserEntity
import gentle.hilt.data.room.user.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class ProfileScreenVM (
    private val userRepository: UserRepository
): ViewModel(){

    private val _userState = MutableStateFlow<UserEntity?>(null)
    val userState: StateFlow<UserEntity?> = _userState

    init {
        observeUser()
    }

    fun deleteUser(user:UserEntity){
        viewModelScope.launch {
            userRepository.deleteUser(user)
        }
    }


    private fun observeUser() {
        viewModelScope.launch {
            userRepository.observedUser.collectLatest {user->
                _userState.value = user
            }
        }
    }
}