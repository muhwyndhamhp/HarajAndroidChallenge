package io.muhwyndhamhp.currencymaster.essential.extension

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object LiveDataExtension {
    fun <T> MutableLiveData<T>.asImmutable(): LiveData<T> = this
}