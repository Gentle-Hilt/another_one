package gentle.hilt.data.room.catalog

import kotlinx.coroutines.flow.Flow

class CatalogRepository(
    private val catalogDao: CatalogDao,
) {

    suspend fun getCatalogListFromDb(): List<CatalogItemEntity?> {
        return catalogDao.getCatalogListFromDb()
    }

    suspend fun insertCatalogItemEntityToDb(catalogItem: CatalogItemEntity) {
        catalogDao.insertCatalogItemEntityToDb(catalogItem)
    }

    suspend fun deleteCatalogItemEntityFromDb(catalogItem: CatalogItemEntity) {
        catalogDao.deleteCatalogItemEntityFromDb(catalogItem)
    }

    fun observerCatalogEntityIsFavorite(itemId: String): Flow<Boolean> {
        return catalogDao.observerCatalogEntityIsFavorite(itemId)
    }

    val observeFavorite: Flow<List<CatalogItemEntity?>> = catalogDao.observeFavorite()
}