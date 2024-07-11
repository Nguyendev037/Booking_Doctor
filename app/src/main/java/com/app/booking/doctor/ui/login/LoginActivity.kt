package com.app.booking.doctor.ui.login

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.os.bundleOf
import com.app.booking.doctor.app.AppDatabase
import com.app.booking.doctor.base.BaseActivity
import com.app.booking.doctor.databinding.ActivityLoginBinding
import com.app.booking.doctor.model.AccountModel
import com.app.booking.doctor.ui.info.EditInfoActivity
import com.app.booking.doctor.ui.main.MainUserActivity
import com.app.booking.doctor.utils.SharePreferenceUtils
import com.app.booking.doctor.utils.ex.clickSafe
import com.app.booking.doctor.utils.ex.gone
import com.app.booking.doctor.utils.ex.openActivity
import com.app.booking.doctor.utils.ex.show
import com.app.booking.doctor.utils.ex.showToast

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    private var isType = 1

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
        showUI(isType)
    }

    private fun showUI(type: Int) {
        isType = type
        if (isType == 1) {
            binding.txtSign.text = "Đăng ký"
            binding.llSignIn.text = "Đăng nhập"
            binding.edtConfirmMatKhau.gone()
        } else {
            binding.txtSign.text = "Đăng nhập"
            binding.llSignIn.text = "Đăng ký"
            binding.edtConfirmMatKhau.show()
        }
    }

    private fun initData() {

    }

    private fun initListener() {
        binding.llSignIn.clickSafe {
            if (isType == 1) {
                checkLogin()
            } else {
                regisAccount()
            }
        }

        binding.txtSign.clickSafe {
            if (isType == 1) {
                showUI(2)
            } else {
                showUI(1)
            }
        }
    }

    private fun regisAccount() {
        if (binding.edtTaiKhoan.text.toString().trim().isEmpty()
            || binding.edtMatKhau.text.toString().trim().isEmpty()
            || binding.edtConfirmMatKhau.text.toString().trim().isEmpty()
        ) {
            showToast("Nhập đầy đủ thông tin!")
            return
        }

        val userName = binding.edtTaiKhoan.text.toString().trim()
        val pass = binding.edtMatKhau.text.toString().trim()
        val passConfirm = binding.edtConfirmMatKhau.text.toString().trim()

        if (pass != passConfirm) {
            showToast("Xác nhận mật khẩu không giống!")
            return
        }

        val check = appDatabase.checkExitUsername(userName)
        if (check) {
            showToast("Tài khoản đã được sử dụng!")
            return
        }

        appDatabase.interAccount(AccountModel(userName, pass, AccountModel.ROLE_USER))
        SharePreferenceUtils.setUsername(userName)
        SharePreferenceUtils.setPassword(pass)

        openActivity(EditInfoActivity::class.java, bundleOf("action" to true), true)
    }

    private fun checkLogin() {
        if (binding.edtTaiKhoan.text.toString().trim().isEmpty()
            || binding.edtMatKhau.text.toString().trim().isEmpty()
        ) {
            showToast("Nhập đầy đủ thông tin!")
            return
        }

        val userName = binding.edtTaiKhoan.text.toString().trim()
        val pass = binding.edtMatKhau.text.toString().trim()

        val account = appDatabase.getAccount(userName, pass)
        account?.let {
            SharePreferenceUtils.setUsername(userName)
            SharePreferenceUtils.setPassword(pass)
            if (it.role == AccountModel.ROLE_USER) {
                val check = appDatabase.checkExitUser(userName)
                if (check) {
                    actionNext(MainUserActivity::class.java)
                } else {
                    openActivity(EditInfoActivity::class.java, bundleOf("action" to true), true)
                }
            }
        } ?: kotlin.run {
            showToast("Thông tin đăng nhập không chính xác!")
        }

    }

    private fun actionNext(pClass: Class<out Activity>) {
        openActivity(pClass, true)
    }

    override fun inflateViewBinding(layoutInflater: LayoutInflater): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

}