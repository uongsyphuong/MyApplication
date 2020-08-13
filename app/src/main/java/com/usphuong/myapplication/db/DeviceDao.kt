package com.usphuong.myapplication.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.usphuong.myapplication.model.Device

@Dao
interface DeviceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(device: Device): Long

    @Query("SELECT * FROM Device")
    fun getListDevice(): List<Device>

//    @Query("DELETE FROM TestModel WHERE uid=:uid")
//    fun deleteTestModel(uid: String): Int
}