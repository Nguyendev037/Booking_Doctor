package com.app.booking.doctor.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.app.booking.doctor.app.AppDatabase
import com.app.booking.doctor.base.BaseAdapterRecyclerView
import com.app.booking.doctor.databinding.LayoutItemScheduleOfUserBinding
import com.app.booking.doctor.model.ScheduleModel
import com.app.booking.doctor.utils.data.DataUtils

class ScheduleUserAdapter : BaseAdapterRecyclerView<ScheduleModel, LayoutItemScheduleOfUserBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): LayoutItemScheduleOfUserBinding {
        return LayoutItemScheduleOfUserBinding.inflate(inflater, parent, false)
    }

    override fun bindData(
        binding: LayoutItemScheduleOfUserBinding,
        item: ScheduleModel,
        position: Int
    ) {
        AppDatabase(binding.root.context).getDoctorById(item.idDoctor)?.let {
            binding.txtName.text = "${it.name}"
        }
        binding.txtDate.text = item.date
        binding.txtTime.text = DataUtils.listScheduleTime[item.time]
    }
}