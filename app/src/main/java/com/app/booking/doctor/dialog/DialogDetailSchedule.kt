package com.app.booking.doctor.dialog

import android.content.Context
import android.view.LayoutInflater
import android.view.Window
import androidx.appcompat.app.AlertDialog
import com.app.booking.doctor.R
import com.app.booking.doctor.app.AppDatabase
import com.app.booking.doctor.databinding.LayoutDialogDetailScheduleBinding
import com.app.booking.doctor.model.ScheduleModel
import com.app.booking.doctor.utils.data.DataUtils
import com.app.booking.doctor.utils.ex.loadGlide
import com.app.booking.doctor.utils.ex.setOnTouchScale

class DialogDetailSchedule(private val context: Context) {

    private val binding by lazy {
        LayoutDialogDetailScheduleBinding.inflate(LayoutInflater.from(context))
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

    fun show(item: ScheduleModel) {

        AppDatabase(binding.root.context).getDoctorById(item.idDoctor)?.let {
            binding.txtName.text = "${it.name}"
            binding.imgAvt.loadGlide(it.avt)
        }
        binding.txtDate.text = item.date
        binding.txtTime.text = DataUtils.listScheduleTime[item.time]
        binding.txtPathological.text = DataUtils.listPathological[item.pathological]

        binding.txtNext.setOnTouchScale{
            hide()
        }

        if (!dialog.isShowing)
            dialog.show()
    }
}