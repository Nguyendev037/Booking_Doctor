package com.app.booking.doctor.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.app.booking.doctor.app.AppDatabase
import com.app.booking.doctor.model.AccountModel

class AccountTable(context: Context) :
    SQLiteOpenHelper(context, AppDatabase.DATABASE_NAME, null, AppDatabase.DATABASE_VERSION) {

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

    fun insertNewDoctor(data: AccountModel) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("userName", data.userName)
        contentValues.put("password", data.password)
        contentValues.put("role", data.role)
        db.insert(TABLE_NAME, null, contentValues)
        db.close()
    }

    fun getAllDataDoctor(): ArrayList<AccountModel> {
        val listData = ArrayList<AccountModel>()
        val selectQuery = "SELECT  * FROM $TABLE_NAME"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val contact = AccountModel(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getInt(2)
                )
                listData.add(contact)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return listData
    }
}