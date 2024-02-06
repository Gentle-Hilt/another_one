package gentle.hilt.data.room.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import gentle.hilt.network.models.goods.Info

class StringListConverter {

    @TypeConverter
    fun fromStringList(value: List<String?>?): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toStringList(value: String): List<String?>? {
        val listType = object : TypeToken<List<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromInfoList(infoList: List<Info?>): String {
        val gson = Gson()
        return gson.toJson(infoList)
    }

    @TypeConverter
    fun toInfoList(infoListString: String?): List<Info> {
        val gson = Gson()
        val type = object : TypeToken<List<Info>>() {}.type
        return gson.fromJson(infoListString, type) ?: emptyList()
    }
}