package com.usphuong.myapplication.feature.scanBluetooth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.usphuong.myapplication.R
import com.usphuong.myapplication.model.Device
import kotlinx.android.synthetic.main.item_device.view.*

class AddDeviceAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var deviceList: MutableList<Device> = mutableListOf()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_device, viewGroup, false)
        return AddDeviceViewHolder(view)
    }

    override fun getItemCount(): Int {
        return deviceList.size
    }

    fun addData(device: Device) {
        this.deviceList.add(device)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as AddDeviceViewHolder
        viewHolder.bind(deviceList[position])
    }
}

class AddDeviceViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    fun bind(device: Device) {
        itemView.tvName.text = device.name
        itemView.tvMacAddress.text = device.macAddress
        itemView.tvRSSI.text = device.rssi.toString()

    }
}
