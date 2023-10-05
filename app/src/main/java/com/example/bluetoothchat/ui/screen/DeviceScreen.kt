package com.example.bluetoothchat.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Device
import androidx.compose.ui.unit.dp
import com.example.bluetoothchat.data.model.BluetoothDevice
import com.example.bluetoothchat.ui.component.BluetoothDeviceList
import com.example.bluetoothchat.ui.state.BluetoothStateUi
import com.example.bluetoothchat.utils.Constance

@Composable
fun DeviceScreen(
    state: BluetoothStateUi,
    onStartScan: () -> Unit,
    onStopScan: () -> Unit,
    onDeviceClick: (BluetoothDevice) -> Unit,
    onStartServer: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        BluetoothDeviceList(
            scannedDevices = state.scannedDevices,
            pairedDevices = state.pairedDevices,
            onClick = onDeviceClick,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = { onStartScan() }) {
                Text(text = "Start Scan")
            }
            Button(onClick = { onStopScan() }) {
                Text(text = "Stop Scan")
            }

            Button(onClick = { onStartServer() }) {
                Text(text = "Start Server")
            }
        }
    }
}