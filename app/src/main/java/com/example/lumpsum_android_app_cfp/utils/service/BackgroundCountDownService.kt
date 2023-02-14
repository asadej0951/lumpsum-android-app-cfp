package com.example.lumpsum_android_app_cfp.utils.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.lumpsum_android_app_cfp.utils.service.ParameterBackgroundCountDown.counter
import java.util.*

class BackgroundCountDownService : Service {

    private var timer: Timer? = null
    private var timerTask: TimerTask? = null

    constructor(applicationContext: Context?) : super() {
        Log.i("HERE", "here I am!")
    }

    constructor() {}

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        startTimer()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        val broadcastIntent = Intent(this, SensorRestartedBroadcastReceiver::class.java)
        broadcastIntent.putExtra("counter",counter)
        sendBroadcast(broadcastIntent)
        overoptimistic()
    }
    private fun startTimer() {
        timer = Timer()
        initializeTimerTask()
        timer!!.schedule(timerTask, 1000, 1000) //
    }
    private fun initializeTimerTask() {
        
        timerTask = object : TimerTask() {
            override fun run() {
                counter++
                if (counter > 30){
                    overoptimistic()
                }
            }
        }
    }
    fun getCounter():Int{
        return counter
    }
    private fun overoptimistic() {
        if (timer != null) {
            timer!!.cancel()
            timer = null
        }
    }
    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}