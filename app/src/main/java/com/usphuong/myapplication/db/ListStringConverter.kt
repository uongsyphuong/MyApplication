package com.usphuong.myapplication.db

import androidx.room.TypeConverter
import com.google.gson.Gson

class ListStringConverter {

    @TypeConverter
    fun listToJson(value: List<String>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String): List<String> =
        Gson().fromJson(value, Array<String>::class.java).toList()
}