package gentle.hilt.data.screens_logic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gentle.hilt.data.room.catalog.CatalogItemEntity
import gentle.hilt.data.room.catalog.CatalogRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class SharedFavoriteVM(
    private val catalogRepository: CatalogRepository,
) : ViewModel() {

    private val _catalogState = MutableStateFlow<List<CatalogItemEntity?>>(emptyList())
    val catalogState: StateFlow<List<CatalogItemEntity?>> = _catalogState


    init {
        observeFavorite()
    }

    private fun observeFavorite() {
        viewModelScope.launch {
            catalogRepository.observeFavorite.collectLatest {
                _catalogState.value = it
            }
        }
    }


    fun isFavorite(catalogItem: CatalogItemEntity): Flow<Boolean> {
        return catalogRepository.observerCatalogEntityIsFavorite(catalogItem.id)
    }

    suspend fun saveCatalogEntity(catalogItem: CatalogItemEntity) {
        catalogRepository.insertCatalogItemEntityToDb(catalogItem)
    }

    suspend fun deleteCatalogEntity(catalogItem: CatalogItemEntity) {
        catalogRepository.deleteCatalogItemEntityFromDb(catalogItem)
    }

}