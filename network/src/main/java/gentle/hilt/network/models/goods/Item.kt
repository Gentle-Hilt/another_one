package gentle.hilt.network.models.goods

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val available: Int? = null,
    val description: String? = "",
    val feedback: Feedback? = Feedback(),
    val id: String? = "",
    val info: List<Info?>? = emptyList(),
    val ingredients: String? = "",
    val price: Price? = Price(),
    val subtitle: String? = "",
    val tags: List<String?>? = emptyList(),
    val title: String? = ""
) : Parcelable
