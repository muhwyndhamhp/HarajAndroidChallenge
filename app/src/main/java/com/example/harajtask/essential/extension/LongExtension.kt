package com.example.harajtask.essential.extension

import java.util.concurrent.TimeUnit

object LongExtension {

    private fun Long.toDay() = TimeUnit.MILLISECONDS.toDays(this)

    private fun Long.toHour() = TimeUnit.MILLISECONDS.toHours(this)

    private fun Long.toMinute() = TimeUnit.MILLISECONDS.toMinutes(this)

    private fun Long.removeNegative() = this.toString().replace("-", "")

    fun Long.toCountDown(): String {
        val day = this
            .toDay()
            .takeIf { it != 0L }
            ?.let { "${it.removeNegative()} days " }
            .orEmpty()
        val hour = (this.toHour() % 24)
            .takeIf { it != 0L }
            ?.let { "${it.removeNegative()} hours " }
            .orEmpty()
        val minute = (this.toMinute() % 60)
            .takeIf { it != 0L }
            ?.let { "${it.removeNegative()} minutes " }
            .orEmpty()

        return "Since $day$hour$minute"
    }

}