package com.example.lumpsum_android_app_cfp

import android.app.Application
import androidx.multidex.MultiDex
import com.example.lumpsum_android_app_cfp.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ProjectApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)

        startKoin {
            androidContext(this@ProjectApplication)
            modules(arrayListOf(viewModelModule))
            androidLogger()
        }

//        var change = ""
//        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
//        val language = sharedPreferences.getString("language", "English")
//        change = when (language) {
//            "Turkish" -> {
//                "tr"
//            }
//            "English" -> {
//                "en"
//            }
//            else -> {
//                ""
//            }
//        }
//
//        BaseActivity.dLocale = Locale(change) //set any locale you want here

    }
}