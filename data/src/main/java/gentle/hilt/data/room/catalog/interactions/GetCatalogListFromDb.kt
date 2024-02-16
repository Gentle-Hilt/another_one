package gentle.hilt.data.room.catalog.interactions

import gentle.hilt.data.room.catalog.CatalogDao

class GetCatalogListFromDb(
    private val catalogDao: CatalogDao
) {

    suspend fun getCatalogList() = catalogDao.getCatalogListFromDb()
}