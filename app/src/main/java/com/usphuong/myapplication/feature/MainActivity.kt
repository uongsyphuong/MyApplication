package com.usphuong.myapplication.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.usphuong.myapplication.R
import com.usphuong.myapplication.model.TestModel
import com.usphuong.myapplication.viewModel.TestViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val testViewModel: TestViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSaveLocal1.setOnClickListener {
            val testModel = TestModel("1", edt1.text?.split(" ")?: listOf())
            testViewModel.insertTestModel(testModel)

        }

        btnSaveLocal2.setOnClickListener {
            val testModel = TestModel("2", edt2.text?.split(" ")?: listOf())
            testViewModel.insertTestModel(testModel)
        }

        btnShow.setOnClickListener {
            testViewModel.getListTestModel()
        }

        testViewModel.insertLiveData.observe(this, Observer {
            Toast.makeText(this, if (it) "Success" else " Fail", Toast.LENGTH_SHORT).show()
        })

        testViewModel.listTestModelLiveData.observe(this, Observer {
            if (it.size == 1){
                tvShow1.text = it[0].toString()
            } else if (it.size == 2){
                tvShow1.text = it[0].toString()
                tvShow2.text = it[1].toString()
            }
        })



    }
}
