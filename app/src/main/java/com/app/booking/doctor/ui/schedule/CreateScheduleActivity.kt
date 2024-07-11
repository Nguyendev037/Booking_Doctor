package com.app.booking.doctor.ui.schedule

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.app.booking.doctor.app.AppDatabase
import com.app.booking.doctor.base.BaseActivity
import com.app.booking.doctor.databinding.ActivityCreateScheduleBinding
import com.app.booking.doctor.model.ScheduleModel
import com.app.booking.doctor.utils.SharePreferenceUtils
import com.app.booking.doctor.utils.data.DataUtils
import com.app.booking.doctor.utils.ex.clickSafe
import java.util.Calendar

class CreateScheduleActivity : BaseActivity<ActivityCreateScheduleBinding>() {

    private val appDatabase by lazy {
        AppDatabase(this)
    }

    private var typeCreate = true

    private var dataModel = ScheduleModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        typeCreate = intent?.getBooleanExtra("create", true) ?: true

        initView()
        initData()
        initListener()
    }

    private fun initView() {
        appDatabase.getAllDataDoctor().let {
            ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                DataUtils.getDataDoctor()
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spDoctor.adapter = adapter
            }
        }


        ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            DataUtils.listScheduleTime
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spTime.adapter = adapter
        }

    }

    private fun initData() {
        if (typeCreate) {
            dataModel = ScheduleModel(
                System.currentTimeMillis().toString(),
                DataUtils.listDoctorFirst[0].id,
                SharePreferenceUtils.getUsername(),
                "", "", 0 ,0
            )
            getNowDate()
        } else {

        }
    }

    private fun initListener() {
        binding.imgBack.clickSafe {
            onBack()
        }

        binding.spDoctor.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                dataModel.idDoctor = DataUtils.listDoctorFirst[position].id
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }


        binding.spTime.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                dataModel.time = position
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        binding.txtDate.clickSafe {
            chooseDate()
        }

        binding.txtNext.clickSafe {
            dataModel.pathological = binding.edtPathological.text.toString()
            appDatabase.insertNewSchedule(dataModel)
            finish()
        }
    }

    private fun getNowDate() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val selectedDate =
            String.format("%02d-%02d-%04d", day, month + 1, year)
        binding.txtDate.text = selectedDate
        dataModel.date = selectedDate
    }

    private fun chooseDate() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate =
                    String.format("%02d-%02d-%04d", selectedDay, selectedMonth + 1, selectedYear)
                binding.txtDate.text = selectedDate
                dataModel.date = selectedDate
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    override fun inflateViewBinding(layoutInflater: LayoutInflater): ActivityCreateScheduleBinding {
        return ActivityCreateScheduleBinding.inflate(layoutInflater)
    }

}