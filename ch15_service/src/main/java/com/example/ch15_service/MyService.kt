package com.example.ch15_service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class MyService : Service() {
    class MyBinder: Binder(){
        fun funA(arg: Int){
        }
        fun funB(arg: Int): Int{
            return arg*arg
        }
    }

    override fun onBind(intent: Intent): IBinder {
       return MyBinder()
    }
}

