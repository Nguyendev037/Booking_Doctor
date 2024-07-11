package com.app.booking.doctor.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.booking.doctor.R
import com.app.booking.doctor.app.AppDatabase
import com.app.booking.doctor.base.BaseActivity
import com.app.booking.doctor.databinding.ActivityEditInfoBinding
import com.app.booking.doctor.databinding.ActivityLoginBinding
import com.app.booking.doctor.utils.ex.gone
import com.app.booking.doctor.utils.ex.show

class EditInfoActivity : BaseActivity<ActivityEditInfoBinding>() {

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

    override fun inflateViewBinding(layoutInflater: LayoutInflater): ActivityEditInfoBinding {
        return ActivityEditInfoBinding.inflate(layoutInflater)
    }

}