package com.example.lumpsum_android_app_cfp.modules

import com.example.lumpsum_android_app_cfp.data.preferences.Preferences
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val utilityModule = module {
    single { Preferences(androidApplication()) }
}