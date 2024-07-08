package com.app.booking.doctor.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.booking.doctor.R
import com.app.booking.doctor.base.BaseActivity
import com.app.booking.doctor.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

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

    }

    override fun inflateViewBinding(layoutInflater: LayoutInflater): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

}