package com.usphuong.myapplication.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.usphuong.myapplication.db.ListStringConverter
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "TestModel")
data class TestModel(
    @PrimaryKey
    var uid: String = "",
    @TypeConverters(ListStringConverter::class)
    var listString: List<String> = listOf()
) : Parcelable {
    override fun toString(): String {
        return "uid$uid ${listString.joinToString(" ")}"
    }
}
