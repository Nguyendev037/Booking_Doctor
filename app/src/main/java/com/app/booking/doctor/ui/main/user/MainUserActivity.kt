package com.app.booking.doctor.ui.main.user

import android.os.Bundle
import android.view.LayoutInflater
import com.app.booking.doctor.app.AppDatabase
import com.app.booking.doctor.base.BaseActivity
import com.app.booking.doctor.databinding.ActivityMainUserBinding

class MainUserActivity : BaseActivity<ActivityMainUserBinding>() {

    private val appDatabase by lazy {
        AppDatabase(this)
    }

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

    override fun inflateViewBinding(layoutInflater: LayoutInflater): ActivityMainUserBinding {
        return ActivityMainUserBinding.inflate(layoutInflater)
    }

}