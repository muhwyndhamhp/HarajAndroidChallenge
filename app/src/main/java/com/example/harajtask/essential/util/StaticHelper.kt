package io.muhwyndhamhp.currencymaster.essential.util

import javax.inject.Inject

class StaticHelper @Inject constructor() {
    fun getSystemTimeInMillis() = System.currentTimeMillis()
}