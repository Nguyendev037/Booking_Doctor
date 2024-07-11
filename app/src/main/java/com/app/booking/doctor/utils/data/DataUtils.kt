package com.app.booking.doctor.utils.data

import com.app.booking.doctor.model.DoctorModel

object DataUtils {

    fun getDataDoctor() : ArrayList<String> {
        val data = ArrayList<String>()
        listDoctorFirst.forEach {
            data.add("[${it.id}] - ${it.name}")
        }
        return data
    }

    val listScheduleTime = listOf(
        "8:00 - 8:30",
        "8:30 - 9:00",
        "9:00 - 9:30",
        "9:30 - 10:00",
        "10:00 - 10:30",
        "10:30 - 11:00",
        "11:00 - 11:30",
        "11:30 - 12:00",
        "13:30 - 14:00",
        "14:00 - 14:30",
        "14:30 - 15:00",
        "15:00 - 15:30",
        "15:30 - 16:00",
        "16:00 - 16:30",
        "16:30 - 17:00",
        "17:00 - 17:30",
        "17:30 - 18:00",
        "18:00 - 18:30",
        "18:30 - 19:00"
    )

    val listDoctorFirst = listOf(
        DoctorModel(
            "07010001", "d001","Nguyễn Văn Chung", "42", 0,
            "[Bác sĩ răng hàm mặt]\nHơn 10 năm kinh nghiệm về nha khoa",
            "file:///android_asset/avt/avt_1.png"
        ),
        DoctorModel(
            "07010002", "d002","Nguyễn Văn Chung", "42", 0,
            "[Bác sĩ răng hàm mặt]\nHơn 10 năm kinh nghiệm về nha khoa",
            "file:///android_asset/avt/avt_1.png"
        ),
        DoctorModel(
            "07010003", "d003","Nguyễn Văn Chung", "42", 0,
            "[Bác sĩ răng hàm mặt]\nHơn 10 năm kinh nghiệm về nha khoa",
            "file:///android_asset/avt/avt_1.png"
        ),
        DoctorModel(
            "07010004", "d004","Nguyễn Văn Chung", "42", 0,
            "[Bác sĩ răng hàm mặt]\nHơn 10 năm kinh nghiệm về nha khoa",
            "file:///android_asset/avt/avt_1.png"
        ),
        DoctorModel(
            "07010005", "d005","Nguyễn Văn Chung", "42", 0,
            "[Bác sĩ răng hàm mặt]\nHơn 10 năm kinh nghiệm về nha khoa",
            "file:///android_asset/avt/avt_1.png"
        ),
        DoctorModel(
            "07010006", "d006","Nguyễn Văn Chung", "42", 0,
            "[Bác sĩ răng hàm mặt]\nHơn 10 năm kinh nghiệm về nha khoa",
            "file:///android_asset/avt/avt_1.png"
        ),
        DoctorModel(
            "07010007", "d007","Nguyễn Văn Chung", "42", 0,
            "[Bác sĩ răng hàm mặt]\nHơn 10 năm kinh nghiệm về nha khoa",
            "file:///android_asset/avt/avt_1.png"
        ),
        DoctorModel(
            "07010008", "d008","Nguyễn Văn Chung", "42", 0,
            "[Bác sĩ răng hàm mặt]\nHơn 10 năm kinh nghiệm về nha khoa",
            "file:///android_asset/avt/avt_1.png"
        ),
        DoctorModel(
            "07010009", "d009","Nguyễn Văn Chung", "42", 0,
            "[Bác sĩ răng hàm mặt]\nHơn 10 năm kinh nghiệm về nha khoa",
            "file:///android_asset/avt/avt_1.png"
        ),
        DoctorModel(
            "07010010", "d010","Nguyễn Văn Chung", "42", 0,
            "[Bác sĩ răng hàm mặt]\nHơn 10 năm kinh nghiệm về nha khoa",
            "file:///android_asset/avt/avt_1.png"
        ),
    )

}