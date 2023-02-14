package com.example.lumpsum_android_app_cfp.data.preferences

import android.content.Context
import android.content.SharedPreferences
import com.example.lumpsum_android_app_cfp.data.preferences.ParameterPreferences.FCM_TOKEN
import com.example.lumpsum_android_app_cfp.data.preferences.ParameterPreferences.FILENAME
import com.example.lumpsum_android_app_cfp.data.preferences.ParameterPreferences.ID
import com.example.lumpsum_android_app_cfp.data.preferences.ParameterPreferences.IMAGE
import com.example.lumpsum_android_app_cfp.data.preferences.ParameterPreferences.NOTIFICATION
import com.example.lumpsum_android_app_cfp.data.preferences.ParameterPreferences.PUSH_TOKEN
import com.example.lumpsum_android_app_cfp.data.preferences.ParameterPreferences.SELECTED_LANGUAGE
import com.example.lumpsum_android_app_cfp.data.preferences.ParameterPreferences.TOKEN
import com.example.lumpsum_android_app_cfp.data.preferences.ParameterPreferences.user_sub_id

class Preferences constructor(private var context: Context) {

    fun getUserId(): String? {
        return getString(ID)
    }

    fun saveUserId(account: String) {
        saveString(ID, account)
    }

    fun saveUserImage(image: String) {
        saveString(IMAGE, image)
    }

    fun getUserImage(): String? {
        return getString(IMAGE)
    }

    fun getToken(): String {
        return getString(TOKEN) ?: ""
    }

    fun saveToken(token: String) {
        saveString(TOKEN, "Bearer $token")
    }

    fun getPushToken(): String? {
        return getString(PUSH_TOKEN)
    }

    fun savePushToken(push_token: String) {
        saveString(PUSH_TOKEN, push_token)
    }

    fun getLanguage(): String? {
        return getString(SELECTED_LANGUAGE)
    }

    fun saveLanguage(language: String) {
        saveString(SELECTED_LANGUAGE, language)
    }

    fun getNotification(): Boolean? {
        return getBoolean(NOTIFICATION)
    }

    fun saveNotification(language: Boolean) {
        saveBoolean(NOTIFICATION, language)
    }

    fun saveFCMToken(fcmToken: String) {
        saveString(FCM_TOKEN, fcmToken)
    }

    fun getFCMToken(): String? {
        return getString(FCM_TOKEN)
    }

    fun clearDataLogout() {
        saveString(TOKEN, "")
    }

    fun saveTest(usersubid: String) {
        saveString(user_sub_id, usersubid)
    }

    fun getTest(): String? {
        return getString(user_sub_id)
    }

    internal fun clear() {
        getSharedPreferences().edit().clear().apply()
    }

    private fun saveString(key: String, value: String) {
        val editor = getSharedPreferences().edit()
        editor.putString(key, value)
        editor.apply()
    }

    private fun getString(key: String): String? {
        return getSharedPreferences().getString(key, null)
    }

    private fun saveBoolean(key: String, value: Boolean) {
        val editor = getSharedPreferences().edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    private fun getBoolean(key: String): Boolean {
        return getSharedPreferences().getBoolean(key, false)
    }

    private fun getSharedPreferences(): SharedPreferences {
        return context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE)
    }
}