package com.example.ch11_jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.ch11_jetpack.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}