package com.example.lumpsum_android_app_cfp.termsService

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TermsServiceViewModel : ViewModel() {

    val textTitle = ObservableField("")
    val textCheckBox = ObservableField("")
    val textButton = ObservableField("")
    val textMessageTermsService = ObservableField("")
    val textButtonSettingLanguage = ObservableField("TH")

    val onClick = MutableLiveData<String>()

    fun onClickSettingLanguage(){
        onClick.value = "SettingLanguage"
    }
}