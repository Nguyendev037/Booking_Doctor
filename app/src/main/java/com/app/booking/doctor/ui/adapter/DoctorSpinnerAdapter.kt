package com.app.booking.doctor.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.app.booking.doctor.R
import com.app.booking.doctor.model.DoctorModel
import com.app.booking.doctor.utils.ex.loadAvt

class DoctorSpinnerAdapter(
    context: Context,
    private val items: List<DoctorModel>
) : ArrayAdapter<DoctorModel>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createViewFromResource(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createViewFromResource(position, convertView, parent)
    }

    private fun createViewFromResource(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_spinner_doctor, parent, false)

        val item = items[position]
        val imageView = view.findViewById<ImageView>(R.id.imgAvt)
        val textView = view.findViewById<TextView>(R.id.txtName)

        imageView.loadAvt(item.avt)
        textView.text = item.name

        return view
    }
}