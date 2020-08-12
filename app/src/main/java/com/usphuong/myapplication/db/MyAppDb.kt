package com.usphuong.myapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.usphuong.myapplication.model.TestModel

@Database(
    entities = [(TestModel::class)],
    version = 1, exportSchema = false
)
@TypeConverters(ListStringConverter::class)
abstract class MyAppDb : RoomDatabase() {

    abstract fun getTestDao(): TestDao

}