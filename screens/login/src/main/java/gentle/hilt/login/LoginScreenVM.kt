package gentle.hilt.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import gentle.hilt.data.room.user.UserEntity
import gentle.hilt.data.room.user.interactions.InsertUserIntoDb
import timber.log.Timber

class LoginScreenVM(
    private val insertUserIntoDb: InsertUserIntoDb,
) : ViewModel() {
    var isUsernameValid by mutableStateOf(false)
    var usernameState by mutableStateOf("")

    var isSurnameValid by mutableStateOf(false)
    var surnameState by mutableStateOf("")


    var isPhoneNumberValid by mutableStateOf(false)
    var phoneState by mutableStateOf("")


    fun observeSurname() {
        val regex = Regex("[а-я]+", RegexOption.IGNORE_CASE)
        isSurnameValid = surnameState.isNotEmpty() && !surnameState.any { it.isWhitespace() || !it.toString().matches(regex) }
    }

    fun observeUsername() {
        val regex = Regex("[а-я]+", RegexOption.IGNORE_CASE)
        isUsernameValid = usernameState.isNotEmpty() && !usernameState.any { it.isWhitespace() || !it.toString().matches(regex) }
    }

    fun observePhone(){
        Timber.d("what is $phoneState")
        isPhoneNumberValid = phoneState.length >= 10
    }

    fun charErrorRules(char: Char): Boolean {
        val regex = Regex("[а-я]+", RegexOption.IGNORE_CASE)
        return char.isLetter() && char.toString().matches(regex)
    }


    suspend fun loginUser() {
        if (isUsernameValid && isSurnameValid && isPhoneNumberValid) {
            val user = UserEntity(
                username = usernameState,
                surname = surnameState,
                phoneNumber = "+7$phoneState"
            )
            insertUserIntoDb.insertUser(user)
        } else {
            Timber.d("error login")
        }
    }

}


