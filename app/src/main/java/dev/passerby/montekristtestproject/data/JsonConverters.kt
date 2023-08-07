package dev.passerby.montekristtestproject.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.JsonObject


class JsonConverters {
    @TypeConverter
    fun listToJson(value: List<String>): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()
}