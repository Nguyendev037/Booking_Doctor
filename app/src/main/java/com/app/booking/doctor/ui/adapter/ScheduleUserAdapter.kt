package com.app.booking.doctor.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.app.booking.doctor.base.BaseAdapterRecyclerView
import com.app.booking.doctor.databinding.LayoutItemDoctorOfUserBinding
import com.app.booking.doctor.model.DoctorModel

class ScheduleUserAdapter : BaseAdapterRecyclerView<DoctorModel, LayoutItemDoctorOfUserBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): LayoutItemDoctorOfUserBinding {
        return LayoutItemDoctorOfUserBinding.inflate(inflater, parent, false)
    }

    private var posChoose = 0

    override fun bindData(binding: LayoutItemDoctorOfUserBinding, item: DoctorModel, position: Int) {
        /*binding.imgFlag.setImageResource(item.iconFlag)
        binding.txtName.text = item.name*/

    }
}