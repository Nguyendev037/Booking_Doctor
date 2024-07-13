package com.app.booking.doctor.`db-method`

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.app.booking.doctor.app.AppDatabase
import com.app.booking.doctor.model.AccountModel

class AccountTable(context: Context) :
    SQLiteOpenHelper(context, AppDatabase.DATABASE_NAME + "account", null, AppDatabase.DATABASE_VERSION) {

    companion object {
        private const val TABLE_NAME = "account_table"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery =
            "CREATE TABLE $TABLE_NAME (" +
                    "userName TEXT PRIMARY KEY, " +
                    "password TEXT, " +
                    "role INT" +
                    ")"
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

    fun insertAccount(data: AccountModel) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("userName", data.userName)
        contentValues.put("password", data.password)
        contentValues.put("role", data.role)
        db.insert(TABLE_NAME, null, contentValues)
        db.close()
    }

    fun getAccount(username: String, pass: String): AccountModel? {
        val selectQuery =
            "SELECT  * FROM $TABLE_NAME WHERE userName = '$username' AND password = '$pass'"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            return AccountModel(
                cursor.getString(0),
                cursor.getString(1),
                cursor.getInt(2)
            )
        }
        cursor.close()
        db.close()
        return null
    }

    fun checkExitUsername(username: String): Boolean {
        val selectQuery =
            "SELECT  * FROM $TABLE_NAME WHERE userName = '$username'"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            return true
        }
        cursor.close()
        db.close()
        return false
    }
}