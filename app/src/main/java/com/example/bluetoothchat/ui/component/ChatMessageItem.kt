package com.example.bluetoothchat.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bluetoothchat.data.model.BluetoothMessage
import com.example.bluetoothchat.ui.theme.Blue
import com.example.bluetoothchat.ui.theme.Green

@Composable
fun ChatMessageItem(
    bluetoothMessage: BluetoothMessage, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    topStart = if (bluetoothMessage.isFromLocalUser) 15.dp else 0.dp,
                    topEnd = 15.dp,
                    bottomStart = 15.dp,
                    bottomEnd = if (bluetoothMessage.isFromLocalUser) 0.dp else 15.dp
                )
            )
            .background(if (bluetoothMessage.isFromLocalUser) Blue else Green).padding(5.dp)
    ) {
        Row {
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = bluetoothMessage.senderName, fontSize = 10.sp, color = Color.White)
        }
        Row {
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = bluetoothMessage.message,
                color = Color.White,
                modifier = Modifier.widthIn(max = 250.dp),
                fontFamily = MaterialTheme.typography.bodySmall.fontFamily
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatMessageScreenPreview() {
    ChatMessageItem(
        bluetoothMessage = BluetoothMessage(
            message = "hello world", senderName = "iphone", isFromLocalUser = true
        )
    )
}