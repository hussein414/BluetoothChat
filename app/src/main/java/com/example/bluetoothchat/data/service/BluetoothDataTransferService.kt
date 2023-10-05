package com.example.bluetoothchat.data.service

import android.bluetooth.BluetoothSocket
import com.example.bluetoothchat.data.model.BluetoothMessage
import com.example.bluetoothchat.utils.mapper.toBluetoothMessage
import com.example.bluetoothchat.utils.TransferFailedIOException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import java.io.IOException

class BluetoothDataTransferService(private val socket: BluetoothSocket) {
    fun listenForIncomingMessages(): Flow<BluetoothMessage> {
        return flow {
            if(!socket.isConnected) {
                return@flow
            }
            val buffer = ByteArray(1024)
            while(true) {
                val byteCount = try {
                    socket.inputStream.read(buffer)
                } catch(e: IOException) {
                    throw TransferFailedIOException()
                }

                emit(
                    buffer.decodeToString(
                        endIndex = byteCount
                    ).toBluetoothMessage(
                        isFromLocalUser = false
                    )
                )
            }
        }.flowOn(Dispatchers.IO)
    }


    suspend fun sendMessage(byteArray: ByteArray): Boolean =
        withContext(Dispatchers.IO) {
            try {
                socket.outputStream.write(byteArray)
            } catch (e: IOException) {
                e.printStackTrace()
                return@withContext false
            }
            true
        }
}