package com.example.bluetoothchat.utils.mapper

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import com.example.bluetoothchat.utils.BluetoothDeviceDomain

@SuppressLint("MissingPermission")
fun BluetoothDevice.toBluetoothDeviceDomain(): BluetoothDeviceDomain {
    return BluetoothDeviceDomain(
        name = name,
        address = address
    )
}