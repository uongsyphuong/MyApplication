package com.usphuong.myapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.usphuong.myapplication.model.TestModel
import com.usphuong.myapplication.repository.TestRepository
import kotlinx.coroutines.launch

class TestViewModel (private val testRepository: TestRepository) : ViewModel() {

    val insertLiveData = MutableLiveData<Boolean>()
    val listTestModelLiveData = MutableLiveData<List<TestModel>>()

    fun insertTestModel(testModel: TestModel) {
        viewModelScope.launch {
            insertLiveData.value = testRepository.insertTestModel(testModel)
        }
    }

    fun getListTestModel(){
        viewModelScope.launch {
            listTestModelLiveData.value = testRepository.getListTestModel()
        }
    }
}