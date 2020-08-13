package com.usphuong.myapplication.repository

import com.usphuong.myapplication.db.DeviceDao
import com.usphuong.myapplication.model.Device
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DeviceRepository(private val deviceDao: DeviceDao) {

    suspend fun insertDevice(device: Device): Boolean {
        return withContext(Dispatchers.Default) {
            val isInsert = deviceDao.insert(device)
            isInsert > 0
        }
    }

    suspend fun getListDevice(): List<Device> {
        return withContext(Dispatchers.Default) {
            deviceDao.getListDevice()
        }
    }

}