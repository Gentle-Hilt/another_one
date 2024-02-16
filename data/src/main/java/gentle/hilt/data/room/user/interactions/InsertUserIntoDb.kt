package gentle.hilt.data.room.user.interactions

import gentle.hilt.data.room.user.UserDao
import gentle.hilt.data.room.user.UserEntity

class InsertUserIntoDb(
    private val userDao: UserDao
) {

    suspend fun insertUser(user:UserEntity) = userDao.insertUser(user)
}