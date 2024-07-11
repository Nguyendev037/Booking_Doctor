package com.app.booking.doctor.app


import android.content.Context
import com.app.booking.doctor.db.AccountTable
import com.app.booking.doctor.model.AccountModel

class AppDatabase(context: Context) {

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "app_booking_doctor"
    }

    private val accountTable by lazy {
        AccountTable(context)
    }

    fun interAccount(data: AccountModel) {
        accountTable.insertAccount(data)
    }

    fun checkExitUsername(username: String) = accountTable.checkExitUsername(username)

    fun getAccount(username: String, pass: String) =
        accountTable.getAccount(username, pass)

}