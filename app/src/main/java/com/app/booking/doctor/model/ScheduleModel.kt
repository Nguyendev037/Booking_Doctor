package com.app.booking.doctor.model

class ScheduleModel(
    var id: String = "",
    var idDoctor: String = "",
    var idUser: String = "",
    var idPathological: String = "",
    var date: String = "",
    var time: Int = 0,
    var status: Int = 0,
) {
}