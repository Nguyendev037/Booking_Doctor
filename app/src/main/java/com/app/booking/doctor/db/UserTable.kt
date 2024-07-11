package com.app.booking.doctor.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.app.booking.doctor.app.AppDatabase
import com.app.booking.doctor.model.UserModel

class UserTable(context: Context) :
    SQLiteOpenHelper(
        context,
        AppDatabase.DATABASE_NAME + "user",
        null,
        AppDatabase.DATABASE_VERSION
    ) {

    companion object {
        private const val TABLE_NAME = "user_table"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery =
            "CREATE TABLE $TABLE_NAME (" +
                    "id TEXT PRIMARY KEY, " +
                    "userName TEXT, " +
                    "name TEXT, " +
                    "age TEXT, " +
                    "sex INT, " +
                    "avt TEXT" +
                    ")"
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

    fun insertUser(data: UserModel) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("id", data.id)
        contentValues.put("userName", data.userName)
        contentValues.put("name", data.name)
        contentValues.put("age", data.age)
        contentValues.put("phone", data.phone)
        contentValues.put("sex", data.sex)
        contentValues.put("avt", data.avt)
        db.insert(TABLE_NAME, null, contentValues)
        db.close()
    }

    fun getAllDataUser(): ArrayList<UserModel> {
        val listData = ArrayList<UserModel>()
        val selectQuery = "SELECT  * FROM $TABLE_NAME"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val contact = UserModel(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getInt(5),
                    cursor.getString(6)
                )
                listData.add(contact)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return listData
    }

    fun getUser(username: String): UserModel? {
        val selectQuery =
            "SELECT  * FROM $TABLE_NAME WHERE userName = '$username'"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            return UserModel(
                cursor.getString(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getInt(5),
                cursor.getString(6)
            )
        }
        cursor.close()
        db.close()
        return null
    }

    fun checkExitUser(username: String): Boolean {
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