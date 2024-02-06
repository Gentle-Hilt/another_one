package gentle.hilt.data.room.catalog

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import gentle.hilt.network.models.goods.Info
import kotlinx.parcelize.Parcelize

@Entity(tableName = "catalog_item")
@Parcelize
data class CatalogItemEntity(
    @PrimaryKey
    val id: String = "",
    val title: String = "",
    val subtitle: String = "",
    val description: String = "",
    val available: Int = 0,
    val rating: Double = 0.0,
    val feedBackCount: Int = 0,
    val oldPrice: String = "",
    val newPrice: String = "",
    val discountPercentage: Int = 0,
    val favorite: Boolean = false,
    val tags: List<String?> = emptyList(),
    val info: List<Info?> = emptyList(),
    val consistOf: String = "",
) : Parcelable