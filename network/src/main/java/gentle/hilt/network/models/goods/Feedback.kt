package gentle.hilt.network.models.goods

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Feedback(
    val count: Int? = null,
    val rating: Double? = null
) : Parcelable
