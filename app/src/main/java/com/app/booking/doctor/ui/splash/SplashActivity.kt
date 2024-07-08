package com.app.booking.doctor.ui.splash

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import com.app.booking.doctor.base.BaseActivity
import com.app.booking.doctor.databinding.ActivitySplashBinding
import com.app.booking.doctor.ui.login.LoginActivity
import com.app.booking.doctor.utils.SharePreferenceUtils
import com.app.booking.doctor.utils.ex.openActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (SharePreferenceUtils.isFirstOpenApp()) {
            insetFirstData()
        } else {
            checkLogin()
        }

    }

    private fun checkLogin() {
        actionNext(LoginActivity::class.java)
    }

    private fun insetFirstData() {



        SharePreferenceUtils.setFirstOpenApp(false)
        actionNext(LoginActivity::class.java)
    }

    private fun actionNext(pClass: Class<out Activity>) {
        Handler(Looper.getMainLooper()).postDelayed({
            openActivity(pClass, true)
        }, 1000L)
    }

    override fun inflateViewBinding(layoutInflater: LayoutInflater): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

}