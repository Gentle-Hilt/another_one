package gentle.hilt.data.room.user.interactions

import gentle.hilt.data.room.user.UserDao
import gentle.hilt.data.room.user.UserEntity

class DeleteUserFromDb(
    private val userDao: UserDao
) {

    suspend fun deleteUser(user: UserEntity) = userDao.deleteUser(user)
}