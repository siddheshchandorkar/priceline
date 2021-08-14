package com.siddhesh.common.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class AppUtils {


    companion object {
        fun getDateInFormat(inputDate: String, inputFormat: String, outputFormat: String): String {
            val inputFormat = SimpleDateFormat(inputFormat, Locale.US)
            val outputFormat = SimpleDateFormat(outputFormat, Locale.US)
            val date: Date
            var output: String = inputDate
            try {
                date = inputFormat.parse(inputDate)
                output = outputFormat.format(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return output
        }
    }
}