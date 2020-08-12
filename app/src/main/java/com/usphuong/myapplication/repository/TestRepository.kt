package com.usphuong.myapplication.repository

import com.usphuong.myapplication.db.TestDao
import com.usphuong.myapplication.model.TestModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class TestRepository(private val testDao: TestDao) {

    suspend fun insertTestModel(testModel: TestModel): Boolean {
        return withContext(Dispatchers.Default) {
            val isInsert = testDao.insert(testModel)
            isInsert > 0
        }
    }

    suspend fun getListTestModel(): List<TestModel> {
        return withContext(Dispatchers.Default) {
            testDao.getTestModel()
        }
    }

}