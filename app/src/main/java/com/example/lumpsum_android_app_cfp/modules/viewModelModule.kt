package com.example.lumpsum_android_app_cfp.modules

import com.example.lumpsum_android_app_cfp.MainActivityViewModel
import com.example.lumpsum_android_app_cfp.startApp.StartAppViewModel
import com.example.lumpsum_android_app_cfp.termsService.TermsServiceViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainActivityViewModel() }

    viewModel { StartAppViewModel() }
    viewModel { TermsServiceViewModel() }
}