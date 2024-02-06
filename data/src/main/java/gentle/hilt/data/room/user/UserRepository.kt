package gentle.hilt.data.room.user

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking


class UserRepository(
    private val userDao: UserDao
) {

    suspend fun getUser(): UserEntity? = runBlocking {
        userDao.getUser()
    }

    val observedUser: Flow<UserEntity?> = userDao.observeUser()

    suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    suspend fun deleteUser(user:UserEntity) {
        userDao.deleteUser(user)
    }


}