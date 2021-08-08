package com.example.harajtask.essential.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.muhwyndhamhp.currencymaster.essential.extension.LiveDataExtension.asImmutable

abstract class BaseViewModel : ViewModel() {

    protected var mutableErrorMessage = MutableLiveData<String>()
    val errorMessage = mutableErrorMessage.asImmutable()

}