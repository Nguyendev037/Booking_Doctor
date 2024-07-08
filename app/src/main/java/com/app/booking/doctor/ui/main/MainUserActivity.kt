package com.app.booking.doctor.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import com.app.booking.doctor.base.BaseActivity
import com.app.booking.doctor.databinding.ActivityMainBinding

class MainUserActivity : BaseActivity<ActivityMainBinding>() {

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

    override fun inflateViewBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

}