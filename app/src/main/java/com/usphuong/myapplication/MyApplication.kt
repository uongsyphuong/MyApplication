package com.usphuong.myapplication

import android.app.Application
import com.usphuong.myapplication.di.appModule
import com.usphuong.myapplication.di.dbModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(arrayListOf(appModule, dbModule))
        }
    }
}