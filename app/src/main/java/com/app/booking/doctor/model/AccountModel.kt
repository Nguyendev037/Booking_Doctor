package com.app.booking.doctor.model

class AccountModel(
    var userName: String,
    var password: String,
    var role: Int,
) {
    companion object {
        const val ROLE_USER = 1
        const val ROLE_DOCTOR = 2
    }
}