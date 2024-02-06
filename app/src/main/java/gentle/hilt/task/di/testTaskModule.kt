package gentle.hilt.task.di

import gentle.hilt.catalog.CatalogScreenVM
import gentle.hilt.data.di.dataModule
import gentle.hilt.data.screens_logic.SharedFavoriteVM
import gentle.hilt.login.LoginScreenVM
import gentle.hilt.network.di.networkModule
import gentle.hilt.profile.ProfileScreenVM
import gentle.hilt.task.SingleActivityVM
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val testTaskModule = module {
    includes(dataModule, networkModule)

    viewModelOf(::SingleActivityVM)
    viewModelOf(::CatalogScreenVM)
    viewModelOf(::SharedFavoriteVM)
    viewModelOf(::ProfileScreenVM)
    viewModelOf(::LoginScreenVM)
}
