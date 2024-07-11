package com.app.booking.doctor.ui.info

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.app.booking.doctor.R
import com.app.booking.doctor.app.AppDatabase
import com.app.booking.doctor.base.BaseActivity
import com.app.booking.doctor.databinding.ActivityEditInfoBinding
import com.app.booking.doctor.model.UserModel
import com.app.booking.doctor.ui.main.user.MainUserActivity
import com.app.booking.doctor.utils.RealPathUtil
import com.app.booking.doctor.utils.SharePreferenceUtils
import com.app.booking.doctor.utils.ex.clickSafe
import com.app.booking.doctor.utils.ex.loadAvt
import com.app.booking.doctor.utils.ex.openActivity
import com.app.booking.doctor.utils.ex.showToast
import java.io.IOException

class EditInfoActivity : BaseActivity<ActivityEditInfoBinding>() {

    private val appDatabase by lazy {
        AppDatabase(this)
    }

    private var typeRegis = true

    private var dataModel = UserModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        typeRegis = intent?.getBooleanExtra("action", true) ?: true

        initView()
        initData()
        initListener()
    }

    private fun initView() {
        if (typeRegis) {
            binding.txtTitle.text = "Tạo thông tin"
        } else {
            binding.txtTitle.text = "Chỉnh sửa thông tin"
        }
    }

    private fun initData() {
        if (!typeRegis) {
            appDatabase.getUser(SharePreferenceUtils.getUsername())?.let {
                dataModel = it
            } ?: kotlin.run {
                dataModel = UserModel(
                    System.currentTimeMillis().toString(), SharePreferenceUtils.getUsername(),
                    "", "", 0, ""
                )
            }
        } else {
            dataModel = UserModel(
                System.currentTimeMillis().toString(), SharePreferenceUtils.getUsername(),
                "", "", 0, ""
            )
        }

        binding.imgAvt.loadAvt(dataModel.avt)

        if (dataModel.sex == 0) {
            binding.rbNam.isChecked = true
        } else {
            binding.rbNu.isChecked = true
        }

        binding.edtName.setText(dataModel.name)
        binding.edtBirthDay.setText(dataModel.age)

    }

    private fun initListener() {
        binding.imgAvt.clickSafe {
            chooseImage()
        }

        binding.txtNext.clickSafe {
            if (binding.edtName.text.toString().isEmpty()) {
                showToast("Nhập tên!")
                return@clickSafe
            }

            if (binding.edtBirthDay.text.toString().isEmpty()) {
                showToast("Nhập tuổi!")
                return@clickSafe
            }

            appDatabase.insertUser(dataModel)

            openActivity(MainUserActivity::class.java, true)
        }

        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbNam -> {
                    dataModel.sex = 0
                }

                R.id.rbNu -> {
                    dataModel.sex = 1
                }
            }
        }
    }

    private fun chooseImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 112)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 112 && resultCode == RESULT_OK && data != null && data.data != null) {
            try {
                val filePath = RealPathUtil.getRealPath(this@EditInfoActivity, data.data)
                dataModel.avt = filePath
                binding.imgAvt.loadAvt(dataModel.avt)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    override fun inflateViewBinding(layoutInflater: LayoutInflater): ActivityEditInfoBinding {
        return ActivityEditInfoBinding.inflate(layoutInflater)
    }

}