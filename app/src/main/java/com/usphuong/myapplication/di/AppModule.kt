package com.usphuong.myapplication.di

import com.usphuong.myapplication.repository.TestRepository
import com.usphuong.myapplication.viewModel.TestViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        TestRepository(get())
    }

    viewModel { TestViewModel(get()) }

}