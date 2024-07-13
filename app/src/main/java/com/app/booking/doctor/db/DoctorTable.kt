package com.app.booking.doctor.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.app.booking.doctor.app.AppDatabase
import com.app.booking.doctor.model.DoctorModel


class DoctorTable(context: Context) :
    SQLiteOpenHelper(
        context,
        AppDatabase.DATABASE_NAME + "doctor",
        null,
        AppDatabase.DATABASE_VERSION
    ) {

    companion object {
        private const val TABLE_NAME = "doctor_table"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery =
            "CREATE TABLE $TABLE_NAME (" +
                    "id TEXT PRIMARY KEY, " +
                    "userName TEXT, " +
                    "name TEXT, " +
                    "age TEXT," +
                    "sex INT," +
                    "pathological INT," +
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
        contentValues.put("userName", data.userName)
        contentValues.put("name", data.name)
        contentValues.put("age", data.age)
        contentValues.put("sex", data.sex)
        contentValues.put("pathological", data.pathological)
        contentValues.put("exp", data.exp)
        contentValues.put("avt", data.avt)
        db.insert(TABLE_NAME, null, contentValues)
        db.close()
    }

    fun getDoctorById(data: String): DoctorModel? {
        val selectQuery = "SELECT  * FROM $TABLE_NAME WHERE id = '$data'"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            return DoctorModel(
                cursor.getString(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getInt(4),
                cursor.getInt(5),
                cursor.getString(6),
                cursor.getString(7)
            )
        }

        cursor.close()
        db.close()
        return null
    }

    fun getDoctorByUsername(data: String): DoctorModel? {
        val selectQuery = "SELECT  * FROM $TABLE_NAME WHERE userName = '$data'"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            return DoctorModel(
                cursor.getString(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getInt(4),
                cursor.getInt(5),
                cursor.getString(6),
                cursor.getString(7)
            )
        }

        cursor.close()
        db.close()
        return null
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
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getInt(5),
                    cursor.getString(6),
                    cursor.getString(7)
                )
                listData.add(contact)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return listData
    }
}