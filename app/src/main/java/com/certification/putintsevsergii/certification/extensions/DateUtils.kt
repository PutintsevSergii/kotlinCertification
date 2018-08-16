package com.certification.putintsevsergii.certification.extensions

import java.text.SimpleDateFormat
import java.util.*

const val DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd"

fun Date.toSimpleDateString(): String {
    val format = SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD, Locale.getDefault())
    return format.format(this)
}

fun Date.addDays(numberOfDays: Int): Date {
    val calendar = Calendar.getInstance()
    calendar.time = this
    calendar.add(Calendar.DAY_OF_YEAR, numberOfDays)
    return calendar.time
}