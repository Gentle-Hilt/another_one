package gentle.hilt.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gentle.hilt.data.room.user.UserEntity
import gentle.hilt.data.room.user.interactions.DeleteUserFromDb
import gentle.hilt.data.room.user.interactions.ObserveUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class ProfileScreenVM (
    private val observeUser: ObserveUser,
    private val deleteUserFromDb: DeleteUserFromDb,
): ViewModel(){

    private val _userState = MutableStateFlow<UserEntity?>(null)
    val userState: StateFlow<UserEntity?> = _userState

    init {
        observeUser()
    }

    fun deleteUser(user:UserEntity){
        viewModelScope.launch {
            deleteUserFromDb.deleteUser(user)
        }
    }


    private fun observeUser() {
        viewModelScope.launch {
            observeUser.observeUser().collectLatest { user->
                _userState.value = user
            }
        }
    }
}