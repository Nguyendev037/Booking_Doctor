package com.app.booking.doctor.ui.main.user

import android.os.Bundle
import android.view.LayoutInflater
import com.app.booking.doctor.app.AppDatabase
import com.app.booking.doctor.base.BaseActivity
import com.app.booking.doctor.databinding.ActivityMainUserBinding
import com.app.booking.doctor.model.UserModel
import com.app.booking.doctor.ui.adapter.DoctorOfUserAdapter
import com.app.booking.doctor.ui.info.DetailInfoActivity
import com.app.booking.doctor.utils.SharePreferenceUtils
import com.app.booking.doctor.utils.ex.clickSafe
import com.app.booking.doctor.utils.ex.loadAvt
import com.app.booking.doctor.utils.ex.openActivity

class MainUserActivity : BaseActivity<ActivityMainUserBinding>() {

    private val appDatabase by lazy {
        AppDatabase(this)
    }

    private val doctorOfUserAdapter by lazy {
        DoctorOfUserAdapter()
    }

    private var userModel = UserModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appDatabase.getUser(SharePreferenceUtils.getUsername())?.let {
            userModel = it
        }

        initView()
        initData()
        initListener()
    }

    private fun initView() {
        binding.txtName.text = userModel.name
        binding.imgAvt.loadAvt(userModel.avt)

        binding.rcyDoctor.adapter = doctorOfUserAdapter
    }

    private fun initData() {
        appDatabase.getAllDataDoctor().let {
            doctorOfUserAdapter.setDataList(it)
        }
    }

    private fun initListener() {
        binding.imgAvt.clickSafe {
            openActivity(DetailInfoActivity::class.java)
        }
    }

    override fun inflateViewBinding(layoutInflater: LayoutInflater): ActivityMainUserBinding {
        return ActivityMainUserBinding.inflate(layoutInflater)
    }

}