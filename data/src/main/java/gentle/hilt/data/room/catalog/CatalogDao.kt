package gentle.hilt.data.room.catalog

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CatalogDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCatalogItemEntityToDb(catalogItem: CatalogItemEntity)

    @Delete
    suspend fun deleteCatalogItemEntityFromDb(catalogItem: CatalogItemEntity)

    @Query("SELECT * FROM catalog_item")
    suspend fun getCatalogListFromDb(): List<CatalogItemEntity>

    @Query("SELECT EXISTS (SELECT * FROM catalog_item WHERE id = :itemId)")
    fun observerCatalogEntityIsFavorite(itemId: String): Flow<Boolean>

    @Query("SELECT * FROM catalog_item")
    fun observeFavorites(): Flow<List<CatalogItemEntity?>>

}