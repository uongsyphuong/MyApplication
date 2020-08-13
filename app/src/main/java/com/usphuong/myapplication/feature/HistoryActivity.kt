package com.usphuong.myapplication.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.usphuong.myapplication.R
import com.usphuong.myapplication.viewModel.DeviceViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryActivity : AppCompatActivity() {

    private val deviceViewModel: DeviceViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
}
