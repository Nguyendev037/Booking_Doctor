package com.app.booking.doctor.ui.main.user

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import com.app.booking.doctor.app.AppDatabase
import com.app.booking.doctor.base.BaseActivity
import com.app.booking.doctor.databinding.ActivityMainUserBinding
import com.app.booking.doctor.model.UserModel
import com.app.booking.doctor.ui.adapter.DoctorOfUserAdapter
import com.app.booking.doctor.ui.adapter.ScheduleUserAdapter
import com.app.booking.doctor.ui.info.DetailInfoActivity
import com.app.booking.doctor.ui.login.LoginActivity
import com.app.booking.doctor.ui.schedule.CreateScheduleActivity
import com.app.booking.doctor.utils.SharePreferenceUtils
import com.app.booking.doctor.utils.ex.clickSafe
import com.app.booking.doctor.utils.ex.loadAvt
import com.app.booking.doctor.utils.ex.openActivity
import com.app.booking.doctor.utils.ex.showToast

class MainUserActivity : BaseActivity<ActivityMainUserBinding>() {

    private val appDatabase by lazy {
        AppDatabase(this)
    }

    private val doctorOfUserAdapter by lazy {
        DoctorOfUserAdapter()
    }

    private val scheduleUserAdapter by lazy {
        ScheduleUserAdapter()
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
        binding.rcySchedule.adapter = scheduleUserAdapter
    }

    private fun initData() {
        appDatabase.getAllDataDoctor().let {
            doctorOfUserAdapter.setDataList(it)
        }
    }

    override fun onResume() {
        super.onResume()

        appDatabase.getAllScheduleOfUser(SharePreferenceUtils.getUsername()).let {
            scheduleUserAdapter.setDataList(it)
        }
    }

    private fun initListener() {
        binding.imgAvt.clickSafe {
            openActivity(DetailInfoActivity::class.java)
        }

        doctorOfUserAdapter.setOnClickItem { item, position ->
            openActivity(CreateScheduleActivity::class.java)
        }

        scheduleUserAdapter.setOnClickItem { item, position ->

        }

        binding.llCreateSchedule.clickSafe {
            openActivity(CreateScheduleActivity::class.java)
        }

        binding.imgLogout.clickSafe {
            SharePreferenceUtils.setUsername("")
            SharePreferenceUtils.setPassword("")
            openActivity(LoginActivity::class.java, true)
        }

    }

    private var isClickBack = false
    override fun onBack() {
        if (isClickBack) {
            finish()
        } else {
            isClickBack = true
            showToast("Nhấn lần nữa để thoát!")
            Handler(Looper.getMainLooper()).postDelayed({
                isClickBack = false
            }, 1000L)
        }
    }

    override fun inflateViewBinding(layoutInflater: LayoutInflater): ActivityMainUserBinding {
        return ActivityMainUserBinding.inflate(layoutInflater)
    }

}