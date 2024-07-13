package com.app.booking.doctor.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.app.booking.doctor.base.BaseAdapterRecyclerView
import com.app.booking.doctor.databinding.LayoutItemDoctorOfUserBinding
import com.app.booking.doctor.model.DoctorModel
import com.app.booking.doctor.utils.data.DataUtils
import com.app.booking.doctor.utils.ex.loadGlide

class DoctorOfUserAdapter : BaseAdapterRecyclerView<DoctorModel, LayoutItemDoctorOfUserBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): LayoutItemDoctorOfUserBinding {
        return LayoutItemDoctorOfUserBinding.inflate(inflater, parent, false)
    }

    override fun bindData(
        binding: LayoutItemDoctorOfUserBinding,
        item: DoctorModel,
        position: Int
    ) {
        binding.imgAvt.loadGlide(item.avt)
        binding.txtName.text = item.name
        binding.txtTitle.text = "[${DataUtils.listPathological[item.pathological]}]\n${item.exp}"

    }
}