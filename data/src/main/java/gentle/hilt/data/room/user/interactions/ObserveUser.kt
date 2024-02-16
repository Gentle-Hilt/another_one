package gentle.hilt.data.room.user.interactions

import gentle.hilt.data.room.user.UserDao

class ObserveUser(
    private val userDao: UserDao
) {

    fun observeUser() = userDao.observeUser()
}