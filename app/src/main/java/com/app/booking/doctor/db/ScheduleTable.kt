package com.app.booking.doctor.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.app.booking.doctor.app.AppDatabase
import com.app.booking.doctor.model.ScheduleModel


class ScheduleTable(context: Context) :
    SQLiteOpenHelper(
        context,
        AppDatabase.DATABASE_NAME + "schedule",
        null,
        AppDatabase.DATABASE_VERSION
    ) {

    companion object {
        private const val TABLE_NAME = "schedule_table"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery =
            "CREATE TABLE $TABLE_NAME (" +
                    "id TEXT PRIMARY KEY, " +
                    "idDoctor TEXT, " +
                    "idUser TEXT, " +
                    "pathological INT," +
                    "date TEXT," +
                    "time INT," +
                    "status INT" +
                    ")"
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

    fun insertNewSchedule(data: ScheduleModel) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("id", data.id)
        contentValues.put("idDoctor", data.idDoctor)
        contentValues.put("idUser", data.idUser)
        contentValues.put("pathological", data.pathological)
        contentValues.put("date", data.date)
        contentValues.put("time", data.time)
        contentValues.put("status", data.status)
        db.insert(TABLE_NAME, null, contentValues)
        db.close()
    }

    fun getScheduleById(data: String): ScheduleModel? {
        val selectQuery = "SELECT  * FROM $TABLE_NAME WHERE id = '$data'"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            return ScheduleModel(
                cursor.getString(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getInt(3),
                cursor.getString(4),
                cursor.getInt(5),
                cursor.getInt(6)
            )
        }

        cursor.close()
        db.close()
        return null
    }

    fun getAllScheduleOfUser(data: String): ArrayList<ScheduleModel> {
        val listData = ArrayList<ScheduleModel>()
        val selectQuery = "SELECT  * FROM $TABLE_NAME WHERE idUser = '$data' ORDER BY id DESC"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val contact = ScheduleModel(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getString(4),
                    cursor.getInt(5),
                    cursor.getInt(6)
                )
                listData.add(contact)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return listData
    }

    fun getAllScheduleOfDoctor(data: String): ArrayList<ScheduleModel> {
        val listData = ArrayList<ScheduleModel>()
        val selectQuery = "SELECT  * FROM $TABLE_NAME WHERE idDoctor = '$data'"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val contact = ScheduleModel(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getString(4),
                    cursor.getInt(5),
                    cursor.getInt(6)
                )
                listData.add(contact)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return listData
    }

    fun checkExitSchedule(idDoctor: String, date: String, time: Int): Boolean {
        val selectQuery =
            "SELECT  * FROM $TABLE_NAME WHERE idDoctor = '$idDoctor' AND date ='$date' AND time =$time"
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