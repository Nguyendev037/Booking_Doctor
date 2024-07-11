package com.app.booking.doctor.dialog

import android.content.Context
import android.view.LayoutInflater
import android.view.Window
import androidx.appcompat.app.AlertDialog
import com.app.booking.doctor.R
import com.app.booking.doctor.app.AppDatabase
import com.app.booking.doctor.databinding.LayoutDialogDetailInfoBinding
import com.app.booking.doctor.databinding.LayoutDialogDetailScheduleBinding
import com.app.booking.doctor.model.ScheduleModel
import com.app.booking.doctor.model.UserModel
import com.app.booking.doctor.utils.data.DataUtils
import com.app.booking.doctor.utils.ex.setOnTouchScale

class DialogDetailInfo(private val context: Context) {

    private val binding by lazy {
        LayoutDialogDetailInfoBinding.inflate(LayoutInflater.from(context))
    }

    private val dialog: AlertDialog by lazy {
        AlertDialog.Builder(context, R.style.dialog_transparent_width).setView(binding.root)
            .create()
    }

    init {
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
    }

    fun isShowing(): Boolean {
        return dialog.isShowing
    }

    fun hide() {
        dialog.dismiss()
    }

    fun show(item: UserModel) {

        binding.txtName.text = item.name
        binding.txtDate.text = item.age

        binding.txtSex.text =
            if (item.sex == 0) {
                "Nam"
            } else {
                "Nữ"
            }
        binding.txtPhone.text = item.phone

        binding.txtNext.setOnTouchScale{
            hide()
        }

        if (!dialog.isShowing)
            dialog.show()
    }
}