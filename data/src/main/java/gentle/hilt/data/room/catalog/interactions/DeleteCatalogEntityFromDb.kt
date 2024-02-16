package gentle.hilt.data.room.catalog.interactions

import gentle.hilt.data.room.catalog.CatalogDao
import gentle.hilt.data.room.catalog.CatalogItemEntity

class DeleteCatalogEntityFromDb(
    private val catalogDao: CatalogDao,
) {
    suspend fun deleteCatalog(catalog: CatalogItemEntity) = catalogDao.deleteCatalogItemEntityFromDb(catalog)
}