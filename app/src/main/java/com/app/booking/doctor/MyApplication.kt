package com.app.booking.doctor

import android.app.Application
import com.app.booking.doctor.utils.SharePreferenceUtils

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        SharePreferenceUtils.init(this)
    }

}