package com.example.bluetoothchat.injection

import android.content.Context
import com.example.bluetoothchat.data.controller.AndroidBluetoothController
import com.example.bluetoothchat.data.controller.BluetoothController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesBluetoothController(@ApplicationContext context: Context): BluetoothController =
        AndroidBluetoothController(context = context)
}