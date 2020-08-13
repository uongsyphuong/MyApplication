package com.usphuong.myapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.usphuong.myapplication.model.Device
import com.usphuong.myapplication.repository.DeviceRepository
import kotlinx.coroutines.launch

class DeviceViewModel (private val deviceRepository: DeviceRepository) : ViewModel() {

    val listDeviceLiveData = MutableLiveData<List<Device>>()

    fun insertDevice(device: Device) {
        viewModelScope.launch {
            deviceRepository.insertDevice(device)
        }
    }

    fun getListDevice(){
        viewModelScope.launch {
            listDeviceLiveData.value = deviceRepository.getListDevice()
        }
    }
}