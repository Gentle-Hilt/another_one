package gentle.hilt.data.room.catalog.interactions

import gentle.hilt.data.room.catalog.CatalogDao

class ObserveFavorites(
    private val catalogDao: CatalogDao
) {
    fun observeFavorites() = catalogDao.observeFavorites()
}