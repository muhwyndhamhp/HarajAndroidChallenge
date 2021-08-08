package com.example.harajtask.essential.util

import javax.inject.Inject

class StaticHelper @Inject constructor() {
    fun getSystemTimeInMillis() = System.currentTimeMillis()
}