package com.example.bluetoothchat.data.controller

import com.example.bluetoothchat.data.model.BluetoothDevice
import com.example.bluetoothchat.data.model.BluetoothMessage
import com.example.bluetoothchat.utils.ConnectionResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface BluetoothController {
    val scannedDevice: StateFlow<List<BluetoothDevice>>
    val pairedDevice: StateFlow<List<BluetoothDevice>>
    val isConnected: Flow<Boolean>
    val errors: SharedFlow<String>

    fun startDiscovery()
    fun stopDiscovery()

    fun startBluetoothServer(): Flow<ConnectionResult>
    fun connectToDevice(device: BluetoothDevice): Flow<ConnectionResult>
    fun closeConnection()
    fun release()


    suspend fun trSendMessage(message:String):BluetoothMessage?
}