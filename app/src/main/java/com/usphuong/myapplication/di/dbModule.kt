package com.usphuong.myapplication.di

import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.usphuong.myapplication.db.MyAppDb
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dbModule = module {

    single {
        Room.databaseBuilder(androidApplication(), MyAppDb::class.java, "myApp.db")
            .build()
    }

    single {
        get<MyAppDb>().getTestDao()
    }

}