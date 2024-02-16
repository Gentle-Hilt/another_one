package gentle.hilt.data.di


import androidx.room.Room
import gentle.hilt.data.room.catalog.interactions.DeleteCatalogEntityFromDb
import gentle.hilt.data.room.catalog.interactions.GetCatalogListFromDb
import gentle.hilt.data.room.catalog.interactions.InsertCatalogItemIntoDb
import gentle.hilt.data.room.catalog.interactions.ObserveCatalogEntityIsFavorite
import gentle.hilt.data.room.catalog.interactions.ObserveFavorites
import gentle.hilt.data.room.database.GoodsDataBase
import gentle.hilt.data.room.user.interactions.DeleteUserFromDb
import gentle.hilt.data.room.user.interactions.GetUserFromDb
import gentle.hilt.data.room.user.interactions.InsertUserIntoDb
import gentle.hilt.data.room.user.interactions.ObserveUser
import org.koin.dsl.module

val dataModule = module {

    single {
        Room.databaseBuilder(
            get(),
            GoodsDataBase::class.java,
            "goods_db"
        ).build()
    }

    single { get<GoodsDataBase>().catalogDao() }
    single { get<GoodsDataBase>().userDao() }

    single { ObserveCatalogEntityIsFavorite(get()) }
    single { ObserveFavorites(get()) }
    single { DeleteCatalogEntityFromDb(get()) }
    single { InsertCatalogItemIntoDb(get()) }
    single { GetCatalogListFromDb(get()) }

    single { DeleteUserFromDb(get()) }
    single { GetUserFromDb(get()) }
    single { InsertUserIntoDb(get()) }
    single { ObserveUser(get()) }
}