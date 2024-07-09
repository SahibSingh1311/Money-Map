package com.example.moneymap

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Utils {
    fun formatDate(dateInMillis: Long): String {
        val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormatter.format(dateInMillis)
    }

    fun formatDate(dateInMillis: Date): String {
        val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormatter.format(dateInMillis)
    }

    fun formatToDecimalValue(d: Double): String {
        return String.format("%.2f", d)
    }
}