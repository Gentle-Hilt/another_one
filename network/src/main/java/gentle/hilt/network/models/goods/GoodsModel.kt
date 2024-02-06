package gentle.hilt.network.models.goods

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GoodsModel(
    val items: List<Item> = emptyList()
) : Parcelable