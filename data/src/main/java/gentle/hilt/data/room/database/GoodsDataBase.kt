package gentle.hilt.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import gentle.hilt.data.room.catalog.CatalogDao
import gentle.hilt.data.room.catalog.CatalogItemEntity
import gentle.hilt.data.room.database.GoodsDataBase.Companion.GOODS_DATABASE_VERSION
import gentle.hilt.data.room.database.converter.StringListConverter
import gentle.hilt.data.room.user.UserDao
import gentle.hilt.data.room.user.UserEntity

@Database(
    entities = [CatalogItemEntity::class, UserEntity::class],
    version = GOODS_DATABASE_VERSION
)
@TypeConverters(StringListConverter::class)
abstract class GoodsDataBase : RoomDatabase() {
    abstract fun catalogDao(): CatalogDao
    abstract fun userDao(): UserDao

    companion object {
        const val GOODS_DATABASE_VERSION = 1
    }
}