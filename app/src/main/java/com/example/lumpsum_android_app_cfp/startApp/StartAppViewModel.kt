package com.example.lumpsum_android_app_cfp.startApp

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StartAppViewModel : ViewModel() {
    val visibilityProgressBar = ObservableField(View.VISIBLE)
    val textShow = ObservableField("")
    val eventCountDown = MutableLiveData<String>()
}