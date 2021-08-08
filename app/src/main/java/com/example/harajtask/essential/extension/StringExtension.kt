package com.example.harajtask.essential.extension

import java.util.*

object StringExtension {

    private fun String?.toLower() = this?.lowercase(Locale.getDefault())

    fun String?.contain(filter: String) = this.toLower()?.contains(filter)
}