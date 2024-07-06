package com.app.booking.doctor.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.app.booking.doctor.model.DoctorModel


class DoctorTable(context: Context) :
    SQLiteOpenHelper(context, AppDatabase.DATABASE_NAME, null, AppDatabase.DATABASE_VERSION) {

    companion object {
        private const val TABLE_NAME = "doctor_table"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery =
            "CREATE TABLE $TABLE_NAME (" +
                    "id TEXT PRIMARY KEY, " +
                    "name TEXT, " +
                    "age TEXT," +
                    "sex INT," +
                    "exp TEXT," +
                    "avt TEXT" +
                    ")"
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

    fun insertNewDoctor(data: DoctorModel) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("id", data.id)
        contentValues.put("name", data.name)
        contentValues.put("age", data.age)
        contentValues.put("sex", data.sex)
        contentValues.put("exp", data.exp)
        contentValues.put("avt", data.avt)
        db.insert(TABLE_NAME, null, contentValues)
        db.close()
    }

    fun getAllDataDoctor(): ArrayList<DoctorModel> {
        val listData = ArrayList<DoctorModel>()
        val selectQuery = "SELECT  * FROM $TABLE_NAME"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val contact = DoctorModel(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getString(4),
                    cursor.getString(5)
                )
                listData.add(contact)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return listData
    }
}