package gentle.hilt.data.di


import androidx.room.Room
import gentle.hilt.data.room.catalog.CatalogRepository
import gentle.hilt.data.room.database.GoodsDataBase
import gentle.hilt.data.room.user.UserRepository
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
    single { CatalogRepository(get()) }
    single { UserRepository(get()) }

}