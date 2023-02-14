package com.example.lumpsum_android_app_cfp

import android.app.Application
import android.preference.PreferenceManager
import androidx.multidex.MultiDex
import com.example.lumpsum_android_app_cfp.modules.utilityModule
import com.example.lumpsum_android_app_cfp.modules.viewModelModule
import com.example.lumpsum_android_app_cfp.view.BaseActivity
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import java.util.*

class ProjectApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)

        startKoin {
            androidContext(this@ProjectApplication)
            modules(arrayListOf(viewModelModule,utilityModule))
            androidLogger()
        }
    }
}