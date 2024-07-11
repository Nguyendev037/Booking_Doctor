package com.app.booking.doctor.app


import android.content.Context
import com.app.booking.doctor.db.AccountTable
import com.app.booking.doctor.db.DoctorTable
import com.app.booking.doctor.db.ScheduleTable
import com.app.booking.doctor.db.UserTable
import com.app.booking.doctor.model.AccountModel
import com.app.booking.doctor.model.DoctorModel
import com.app.booking.doctor.model.ScheduleModel
import com.app.booking.doctor.model.UserModel

class AppDatabase(context: Context) {

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "app_booking_doctor"
    }

    private val accountTable by lazy {
        AccountTable(context)
    }

    private val userTable by lazy {
        UserTable(context)
    }

    private val doctorTable by lazy {
        DoctorTable(context)
    }

    private val scheduleTable by lazy {
        ScheduleTable(context)
    }


    //========================================Account=================================================
    fun interAccount(data: AccountModel) {
        accountTable.insertAccount(data)
    }

    fun checkExitUsername(username: String) = accountTable.checkExitUsername(username)

    fun getAccount(username: String, pass: String) =
        accountTable.getAccount(username, pass)


    //========================================User=================================================
    fun insertUser(data: UserModel) {
        userTable.insertUser(data)
    }

    fun checkExitUser(username: String) = userTable.checkExitUser(username)

    fun getUser(username: String) =
        userTable.getUser(username)


    //========================================User=================================================
    fun insertNewDoctor(data: DoctorModel) {
        doctorTable.insertNewDoctor(data)
    }

    fun getDoctorById(data: String) =
        doctorTable.getDoctorById(data)

    fun getDoctorByUsername(data: String) =
        doctorTable.getDoctorByUsername(data)

    fun getAllDataDoctor() =
        doctorTable.getAllDataDoctor()


    //======================================Schedule===============================================
    fun insertNewSchedule(data: ScheduleModel) {
        scheduleTable.insertNewSchedule(data)
    }

    fun getAllScheduleOfUser(data: String) =
        scheduleTable.getAllScheduleOfUser(data)

    fun getAllScheduleOfDoctor(data: String) =
        scheduleTable.getAllScheduleOfDoctor(data)

    fun getScheduleById(data: String) =
        scheduleTable.getScheduleById(data)

}