package com.usphuong.myapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.usphuong.myapplication.model.Device

@Database(
    entities = [(Device::class)],
    version = 1, exportSchema = false
)
abstract class MyAppDb : RoomDatabase() {

    abstract fun getDeviceDao(): DeviceDao

}