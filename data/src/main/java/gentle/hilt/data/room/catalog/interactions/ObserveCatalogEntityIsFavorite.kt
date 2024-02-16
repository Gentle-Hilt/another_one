package gentle.hilt.data.room.catalog.interactions

import gentle.hilt.data.room.catalog.CatalogDao

class ObserveCatalogEntityIsFavorite(
    private val catalogDao: CatalogDao
) {
    fun catalogEntityIsFavorite(itemId: String) = catalogDao.observerCatalogEntityIsFavorite(itemId)
}