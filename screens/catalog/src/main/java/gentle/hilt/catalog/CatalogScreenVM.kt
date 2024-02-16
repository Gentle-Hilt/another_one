package gentle.hilt.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gentle.hilt.data.room.catalog.CatalogItemEntity
import gentle.hilt.data.room.catalog.interactions.GetCatalogListFromDb
import gentle.hilt.data.room.mapGoodsToCatalogItemEntity
import gentle.hilt.network.NetworkRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber


class CatalogScreenVM (
    private val networkRepository: NetworkRepository,
    private val getCatalogListFromDb: GetCatalogListFromDb,
) : ViewModel() {

    private val _catalogState = MutableStateFlow<List<CatalogItemEntity?>>(emptyList())
    val catalogState: StateFlow<List<CatalogItemEntity?>> = _catalogState

    init {
        fetchCatalog()
    }

    private fun fetchCatalog() {
        viewModelScope.launch {
            networkRepository.getGoods()?.let { goods->
                Timber.d("updating catalog state")
                val updatedCatalog = mapGoodsToCatalogItemEntity(goods)

                val catalogFromDb = getCatalogListFromDb.getCatalogList()
                val updatedCatalogWithFavorites = updatedCatalog.map { item ->
                    val favoriteItem = catalogFromDb.find { it?.id == item.id }
                    item.copy(favorite = favoriteItem?.favorite ?: false)
                }

                _catalogState.value = updatedCatalogWithFavorites
            }
        }
    }

}