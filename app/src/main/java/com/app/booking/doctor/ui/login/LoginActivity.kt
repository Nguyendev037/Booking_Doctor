package com.app.booking.doctor.ui.login

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import com.app.booking.doctor.base.BaseActivity
import com.app.booking.doctor.databinding.ActivityLoginBinding
import com.app.booking.doctor.ui.main.user.MainUserActivity
import com.app.booking.doctor.utils.ex.clickSafe
import com.app.booking.doctor.utils.ex.openActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    private var isType = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        initData()
        initListener()
    }

    private fun initView() {

    }

    private fun initData() {

    }

    private fun initListener() {
        binding.txtSign.clickSafe {
            if (isType == 1) {
                checkLogin()
            } else {
                regisAccount()
            }
        }
    }

    private fun regisAccount() {

    }

    private fun checkLogin() {
        actionNext(MainUserActivity::class.java)
    }

    private fun actionNext(pClass: Class<out Activity>) {
        openActivity(pClass, true)
    }

    override fun inflateViewBinding(layoutInflater: LayoutInflater): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

}