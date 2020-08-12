package com.usphuong.myapplication.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.usphuong.myapplication.model.TestModel

@Dao
interface TestDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(testModel: TestModel?): Long

    @Query("SELECT * FROM TestModel")
    fun getTestModel(): List<TestModel>

//    @Query("DELETE FROM TestModel WHERE uid=:uid")
//    fun deleteTestModel(uid: String): Int
}