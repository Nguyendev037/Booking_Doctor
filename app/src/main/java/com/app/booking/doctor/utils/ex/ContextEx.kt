package com.app.booking.doctor.utils.ex

import android.app.ActivityManager
import android.app.Service
import android.content.Context
import android.content.Context.ACTIVITY_SERVICE
import android.content.Intent
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import java.io.IOException
import java.io.InputStream

fun Context.showToast(msg: String, isShowDurationLong: Boolean = false) {
    val duration = if (isShowDurationLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
    Toast.makeText(this, msg, duration).show()
}

fun Fragment.showToast(msg: String, isShowDurationLong: Boolean = false) {
    requireContext().showToast(msg, isShowDurationLong)
}

fun Context.hasPermission(permission: String): Boolean {
    return ContextCompat.checkSelfPermission(
        this,
        permission
    ) == PackageManager.PERMISSION_GRANTED
}

fun Context.loadJsonFromAsset(path: String): String {
    var json: String = ""
    try {
        val ios: InputStream = assets.open(path)
        val size = ios.available()
        val buffer = ByteArray(size)
        ios.read(buffer)
        ios.close()
        json = String(buffer, Charsets.UTF_8)
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return json
}


