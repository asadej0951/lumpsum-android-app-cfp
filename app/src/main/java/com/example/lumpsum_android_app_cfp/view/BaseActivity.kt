package com.example.lumpsum_android_app_cfp.view

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.lumpsum_android_app_cfp.data.preferences.Preferences
import org.koin.android.ext.android.inject
import qiu.niorgai.StatusBarCompat
import java.util.*

abstract class BaseActivity : AppCompatActivity() {

    val mPreferences: Preferences by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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