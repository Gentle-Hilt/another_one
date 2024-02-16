package gentle.hilt.data.room.user.interactions

import gentle.hilt.data.room.user.UserDao
import kotlinx.coroutines.runBlocking

class GetUserFromDb(
    private val userDao: UserDao
) {

    suspend fun getUser() = runBlocking { userDao.getUser() }
}