package gentle.hilt.data.room.catalog.interactions

import gentle.hilt.data.room.catalog.CatalogDao
import gentle.hilt.data.room.catalog.CatalogItemEntity

class InsertCatalogItemIntoDb(
    private val catalogDao: CatalogDao,
) {

    suspend fun insertCatalog(catalog:CatalogItemEntity) = catalogDao.insertCatalogItemEntityToDb(catalog)
}