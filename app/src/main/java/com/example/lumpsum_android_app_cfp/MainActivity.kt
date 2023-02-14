package com.example.lumpsum_android_app_cfp

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.lumpsum_android_app_cfp.databinding.ActivityMainBinding
import com.example.lumpsum_android_app_cfp.utils.language.LocaleHelper
import com.example.lumpsum_android_app_cfp.utils.service.BackgroundCountDownService
import com.example.lumpsum_android_app_cfp.utils.service.ParameterBackgroundCountDown.counter
import com.example.lumpsum_android_app_cfp.view.BaseActivity


class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var context: Context
    companion object{

    }
    private lateinit var mBackgroundCountDownService : BackgroundCountDownService
    private lateinit var mServiceIntent :Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = LocaleHelper().setLocale(this,mPreferences.getLanguage()?:"th")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onSetStatusBarColor(R.color.white)
         mBackgroundCountDownService = BackgroundCountDownService(this)
         mServiceIntent = Intent(this, mBackgroundCountDownService::class.java)
    }
    private fun isMyServiceRunning(serviceClass: Class<*>): Boolean {
        val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (service in manager.getRunningServices(Int.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                return true
            }
        }
        return false
    }

    override fun onStop() {
        super.onStop()
        if (!isMyServiceRunning(mBackgroundCountDownService::class.java)) {
            startService(mServiceIntent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        stopService(mServiceIntent)
       if(mBackgroundCountDownService.getCounter() > 10){
           finish()
       }
    }
}