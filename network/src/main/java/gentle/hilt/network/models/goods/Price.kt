package gentle.hilt.network.models.goods

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Price(
    val discount: Int? = null,
    val price: String? = "",
    val priceWithDiscount: String? = "",
    val unit: String? = ""
) : Parcelable