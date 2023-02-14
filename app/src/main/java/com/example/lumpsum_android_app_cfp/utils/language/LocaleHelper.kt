package com.example.lumpsum_android_app_cfp.utils.language

import android.content.Context
import android.preference.PreferenceManager
import com.example.lumpsum_android_app_cfp.data.preferences.ParameterPreferences.SELECTED_LANGUAGE
import com.example.lumpsum_android_app_cfp.data.preferences.Preferences
import java.util.*

class LocaleHelper {

    fun setLocale(context: Context, language: String): Context {
        Preferences(context).saveLanguage(language)
//        persist(context, language)
        return updateResourcesLegacy(context, language)
    }

    private fun updateResources(context: Context, language: String): Context {
        val local: Locale = Locale(language)
        Locale.setDefault(local)
        val configuration = context.resources.configuration
        configuration.setLocale(local)
        configuration.setLayoutDirection(local)
        return context.createConfigurationContext(configuration)
    }

    private fun persist(context: Context, language: String) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putString(SELECTED_LANGUAGE, language)
        editor.apply()
    }

    private fun updateResourcesLegacy(context: Context, language: String): Context {
        val local: Locale = Locale(language)
        Locale.setDefault(local)
        val resources = context.resources
        val configuration = resources.configuration
        configuration.locale = local
        configuration.setLayoutDirection(local)
        resources.updateConfiguration(configuration, resources.displayMetrics)
        return context
    }
}