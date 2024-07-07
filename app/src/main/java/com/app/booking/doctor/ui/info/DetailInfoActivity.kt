package com.app.booking.doctor.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.booking.doctor.R
import com.app.booking.doctor.base.BaseActivity
import com.app.booking.doctor.databinding.ActivityDetailInfoBinding
import com.app.booking.doctor.databinding.ActivityLoginBinding

class DetailInfoActivity  : BaseActivity<ActivityDetailInfoBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun inflateViewBinding(layoutInflater: LayoutInflater): ActivityDetailInfoBinding {
        return ActivityDetailInfoBinding.inflate(layoutInflater)
    }

}