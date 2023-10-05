package com.example.bluetoothchat.ui.state

import com.example.bluetoothchat.data.model.BluetoothDevice
import com.example.bluetoothchat.data.model.BluetoothMessage
import java.security.MessageDigest
import java.util.Scanner

data class BluetoothStateUi(
    val scannedDevices: List<BluetoothDevice> = emptyList(),
    val pairedDevices: List<BluetoothDevice> = emptyList(),
    val isConnected: Boolean = false,
    val isConnecting: Boolean = false,
    val errorMessage: String? = null,
    val message: List<BluetoothMessage> = emptyList(),
)