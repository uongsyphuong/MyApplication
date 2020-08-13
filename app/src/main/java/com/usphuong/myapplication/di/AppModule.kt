package com.usphuong.myapplication.di

import com.usphuong.myapplication.repository.DeviceRepository
import com.usphuong.myapplication.viewModel.DeviceViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        DeviceRepository(get())
    }

    viewModel { DeviceViewModel(get()) }

}