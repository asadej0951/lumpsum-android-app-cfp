package com.example.lumpsum_android_app_cfp.view

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import qiu.niorgai.StatusBarCompat
import java.util.*

abstract class BaseActivity : AppCompatActivity() {

//    companion object {
//        var dLocale: Locale? = null
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
//
//    init {
//        updateConfig(this)
//    }
//
//    private fun updateConfig(wrapper: ContextThemeWrapper) {
//        if (dLocale == Locale("")) // Do nothing if dLocale is null
//            return
//
//        Locale.setDefault(dLocale)
//        val configuration = Configuration()
//        configuration.setLocale(dLocale)
//        wrapper.applyOverrideConfiguration(configuration)
//    }

    fun onSetStatusBarColor(color: Int) {
        StatusBarCompat.setStatusBarColor(this, ContextCompat.getColor(this, color))
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    fun onSetStatusBar() {
        StatusBarCompat.translucentStatusBar(this, true)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    fun onSetFullScreenStatusBar() {
        StatusBarCompat.translucentStatusBar(this)
        StatusBarCompat.translucentStatusBar(this, true)
    }

}