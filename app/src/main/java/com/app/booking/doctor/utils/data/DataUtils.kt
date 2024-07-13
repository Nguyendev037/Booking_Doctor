package com.app.booking.doctor.utils.data

import com.app.booking.doctor.model.DoctorModel
import java.text.FieldPosition

object DataUtils {

    fun getDataDoctor(): ArrayList<String> {
        val data = ArrayList<String>()
        listDoctorFirst.forEach {
            data.add("[${it.id}] - ${it.name}")
        }
        return data
    }

    fun getDataDoctorByPathological(pathological: Int): ArrayList<String> {
        val data = ArrayList<String>()
        listDoctorFirst.filter {
            it.pathological == pathological
        }.forEach {
            data.add("[${it.id}] - ${it.name}")
        }
        return data
    }

    fun getFirstDoctorIdOfPathological(pathological: Int) : String{
        return listDoctorFirst.filter {
            it.pathological == pathological
        }[0].id
    }

    fun getFirstDoctorId(pathological: Int, position: Int) : String{
        return listDoctorFirst.filter {
            it.pathological == pathological
        }[position].id
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

    val listPathological = listOf(
        "Khám tổng quát",
        "Tim mạch",
        "Nội soi",
        "Xương khớp",
        "Nội tiết",
        "Răng-Hàm-Mặt"
    )

    val listDoctorFirst = listOf(
        DoctorModel(
            "07010001", "d001", "Nguyễn Văn Chung", "42", 0,
            5,
            "Hơn 10 năm kinh nghiệm về nha khoa",
            "file:///android_asset/avt/avt_1.png"
        ),
        DoctorModel(
            "07010002", "d002", "Phạm Thành Quang", "40", 0,
            3,
            "Hơn 8 năm kinh nghiệm về các bệnh xương khớp",
            "file:///android_asset/avt/avt_2.png"
        ),
        DoctorModel(
            "07010003", "d003", "Trần Văn Khang", "46", 0,
            5,
            "Hơn 14 năm kinh nghiệm về răng hàm mặt",
            "file:///android_asset/avt/avt_3.png"
        ),
        DoctorModel(
            "07010004", "d004", "Nguyễn Văn Bảy", "41", 0,
            0,
            "Hơn 9 năm kinh nghiệm trong ngành",
            "file:///android_asset/avt/avt_3.png"
        ),
        DoctorModel(
            "07010005", "d005", "Nguyễn Thị Dung", "42", 1,
            4,
            "Hơn 10 năm kinh nghiệm trong ngành",
            "file:///android_asset/avt/avt_2.png"
        ),
        DoctorModel(
            "07010006", "d006", "Vũ Tiến Hoàng", "47", 0,
            3,
            "Hơn 15 năm kinh nghiệm về xương khớp",
            "file:///android_asset/avt/avt_1.png"
        ),
        DoctorModel(
            "07010007", "d007", "Phạm Quang Trường", "42", 0,
            1,
            "Hơn 10 năm kinh nghiệm về tim mạch",
            "file:///android_asset/avt/avt_1.png"
        ),
        DoctorModel(
            "07010008", "d008", "Vũ Văn Nam", "42", 0,
            0,
            "Hơn 10 năm kinh nghiệm khám chữa bệnh",
            "file:///android_asset/avt/avt_3.png"
        ),
        DoctorModel(
            "07010009", "d009", "Trần THị Phương", "42", 1,
            1,
            "Hơn 10 năm kinh nghiệm về tim mạch",
            "file:///android_asset/avt/avt_2.png"
        ),
        DoctorModel(
            "07010010", "d010", "Nguyễn Thị Quỳnh", "42", 1,
            2,
            "Hơn 10 năm kinh nghiệm nội soi",
            "file:///android_asset/avt/avt_2.png"
        ),
        DoctorModel(
            "070100011", "d011", "Nguyễn Thị Thương", "42", 1,
            4,
            "Hơn 10 năm kinh nghiệm trong ngành",
            "file:///android_asset/avt/avt_2.png"
        ),
    )

}