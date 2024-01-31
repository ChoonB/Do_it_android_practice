package com.example.ch15_service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.activity.ComponentActivity
import com.example.ch15_service.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val connection: ServiceConnection = object : ServiceConnection{
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                val serviceBinder = service as MyService.MyBinder
            }
            override fun onServiceDisconnected(name: ComponentName?) { }
        }

        val intent = Intent(this, MyService::class.java)
        bindService(intent, connection, Context.BIND_AUTO_CREATE)
        unbindService(connection)


    }
}

