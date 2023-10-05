package com.example.bluetoothchat.utils.mapper

import com.example.bluetoothchat.data.model.BluetoothMessage

fun BluetoothMessage.toByteArray(): ByteArray = buildString {
    append(senderName)
    append("#")
    append(message)
}.encodeToByteArray()

fun String.toBluetoothMessage(isFromLocalUser: Boolean): BluetoothMessage {
    val name = substringBeforeLast("#")
    val message = substringAfter("#")
    return BluetoothMessage(
        message = message,
        senderName = name,
        isFromLocalUser = isFromLocalUser
    )
}

