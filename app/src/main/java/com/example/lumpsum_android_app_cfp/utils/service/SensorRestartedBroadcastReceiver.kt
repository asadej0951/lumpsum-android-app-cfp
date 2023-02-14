package com.example.lumpsum_android_app_cfp.utils.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.util.Log
import com.example.lumpsum_android_app_cfp.MainActivity
import com.example.lumpsum_android_app_cfp.utils.service.ParameterBackgroundCountDown.counter

class SensorRestartedBroadcastReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let {
            val counterData = it.getIntExtra("counter",0)
            if (counterData > 10){
                val intent = Intent(context,MainActivity::class.java)
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK)
                context!!.startActivity(intent)
            }
            counter = 0
            Log.i("CountDownTime","Service Stops! $counterData")
        }

    }
}