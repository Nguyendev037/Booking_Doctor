package com.app.booking.doctor.utils

import android.content.Context
import android.content.SharedPreferences

object SharePreferenceUtils {

    const val PER_NAME = "data_app_shared_preference"

    lateinit var sharePref: SharedPreferences

    fun init(context: Context) {
        if (!SharePreferenceUtils::sharePref.isInitialized) {
            sharePref = context.getSharedPreferences(PER_NAME, Context.MODE_PRIVATE)
        }
    }

    fun <T> saveKey(key: String, value: T) {
        when (value) {
            is String -> sharePref.edit().putString(key, value).apply()
            is Int -> sharePref.edit().putInt(key, value).apply()
            is Boolean -> sharePref.edit().putBoolean(key, value).apply()
            is Long -> sharePref.edit().putLong(key, value).apply()
            is Float -> sharePref.edit().putFloat(key, value).apply()
        }

    }

    fun getString(key: String, value: String = ""): String {
        return sharePref.getString(key, value)?.trim() ?: value
    }

    fun getInt(key: String, defaultValue: Int = 0): Int {
        return sharePref.getInt(key, defaultValue)
    }

    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return sharePref.getBoolean(key, defaultValue)
    }

    fun getLong(key: String): Long {
        return sharePref.getLong(key, 0L)
    }

    fun getFloat(key: String): Float {
        return sharePref.getFloat(key, 0f)
    }

    fun isFirstOpenApp(): Boolean = getBoolean("isFirstOpenApp", true)
    fun setFirstOpenApp(value: Boolean) = saveKey("isFirstOpenApp", value)

    fun getLanguageCode(): String = getString("getLanguageCode", "")
    fun setLanguageCode(value: String) = saveKey("getLanguageCode", value)

    fun isShowIntro(): Boolean = getBoolean("isShowIntro", true)
    fun setShowIntro(value: Boolean) = saveKey("isShowIntro", value)

    fun getYearShowedRateApp(): Int = getInt("getYearShowedRateApp", 0)
    fun setYearShowedRateApp(value: Int) = saveKey("getYearShowedRateApp", value)




}