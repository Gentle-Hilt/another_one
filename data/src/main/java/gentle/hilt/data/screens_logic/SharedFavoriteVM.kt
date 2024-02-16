package gentle.hilt.data.screens_logic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gentle.hilt.data.room.catalog.CatalogItemEntity
import gentle.hilt.data.room.catalog.interactions.DeleteCatalogEntityFromDb
import gentle.hilt.data.room.catalog.interactions.InsertCatalogItemIntoDb
import gentle.hilt.data.room.catalog.interactions.ObserveCatalogEntityIsFavorite
import gentle.hilt.data.room.catalog.interactions.ObserveFavorites
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class SharedFavoriteVM(
    private val observeCatalogEntityIsFavorite: ObserveCatalogEntityIsFavorite,
    private val observeFavorites: ObserveFavorites,
    private val deleteCatalogEntityFromDb: DeleteCatalogEntityFromDb,
    private val insertCatalogEntityIntoDb: InsertCatalogItemIntoDb,
) : ViewModel() {

    private val _catalogState = MutableStateFlow<List<CatalogItemEntity?>>(emptyList())
    val catalogState: StateFlow<List<CatalogItemEntity?>> = _catalogState


    init {
        observeFavorites()
    }

    private fun observeFavorites() {
        viewModelScope.launch {
            observeFavorites.observeFavorites().collectLatest {
                _catalogState.value = it
            }
        }
    }


    fun isFavorite(catalogItem: CatalogItemEntity): Flow<Boolean> {
        return observeCatalogEntityIsFavorite.catalogEntityIsFavorite(catalogItem.id)
    }

    suspend fun saveCatalogEntity(catalogItem: CatalogItemEntity) {
        insertCatalogEntityIntoDb.insertCatalog(catalogItem)
    }

    suspend fun deleteCatalogEntity(catalogItem: CatalogItemEntity) {
        deleteCatalogEntityFromDb.deleteCatalog(catalogItem)
    }

}