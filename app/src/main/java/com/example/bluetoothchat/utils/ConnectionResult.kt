package com.example.bluetoothchat.utils

import com.example.bluetoothchat.data.model.BluetoothMessage

sealed class ConnectionResult {
    object ConnectionEstablished : ConnectionResult()
    data class Error(val message: String) : ConnectionResult()
    data class TransferSucceeded(val message: BluetoothMessage) : ConnectionResult()
}
