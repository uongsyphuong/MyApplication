package com.usphuong.myapplication.feature.scanBluetooth

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.le.BluetoothLeScanner
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanFilter
import android.bluetooth.le.ScanResult
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.usphuong.myapplication.R
import com.usphuong.myapplication.model.Device
import com.usphuong.myapplication.viewModel.DeviceViewModel
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class HomeActivity : AppCompatActivity() {

    private val REQUEST_LOCATION_PERMISSION = 0
    private val deviceViewModel: DeviceViewModel by viewModel()

    private var mBluetoothAdapter: BluetoothAdapter? = null
    private var mBluetoothLeScanner: BluetoothLeScanner? = null

    private lateinit var addDeviceAdapter: AddDeviceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        Glide.with(this)
            .load(R.drawable.bg_scan)
            .into(ivScan)

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        mBluetoothLeScanner = mBluetoothAdapter?.bluetoothLeScanner

        setupAdapter()

        if (hasPermission()) scanBluetooth()
        else requestLocationPermission()
    }

    private fun setupAdapter() {
        rvDevice.layoutManager = LinearLayoutManager(this)
        addDeviceAdapter = AddDeviceAdapter()
        rvDevice.adapter = addDeviceAdapter
    }

    private fun scanBluetooth() {
        mBluetoothLeScanner?.startScan(scanCallback)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_LOCATION_PERMISSION -> {
                scanBluetooth()
            }
        }
    }

    private fun requestLocationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION
                ),
                REQUEST_LOCATION_PERMISSION
            )
        }
    }

    private fun hasPermission(): Boolean {
        val permission =
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        return permission == PackageManager.PERMISSION_GRANTED
    }

    private var scanCallback = object : ScanCallback() {
        @SuppressLint("SimpleDateFormat")
        override fun onScanResult(callbackType: Int, result: ScanResult) {
            for (device in addDeviceAdapter.deviceList) {
                if (device.macAddress.contains(result.device.address)) {
                    return
                }
            }
            ivScan.visibility = View.GONE
            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = sdf.format(Date())
            val device = Device(
                name = result.device.name?: "n/a",
                macAddress = result.device.address,
                rssi = result.rssi,
                lastSeen = currentDate
            )
            deviceViewModel.insertDevice(device)
            addDeviceAdapter.addData(device)
        }

        override fun onScanFailed(errorCode: Int) {
            super.onScanFailed(errorCode)
            Log.i("BLE", "error")
        }
    }

}