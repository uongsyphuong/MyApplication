package com.usphuong.myapplication.model


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Device")
data class Device(
    var name: String? = null,
    @PrimaryKey
    var macAddress: String = "",
    var rssi: Int? = null,
    var lastSeen: String? = null
) : Parcelable
