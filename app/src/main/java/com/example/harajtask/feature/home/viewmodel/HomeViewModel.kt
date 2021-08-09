package com.example.harajtask.feature.home.viewmodel

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.harajtask.essential.base.BaseViewModel
import com.example.harajtask.essential.data.Post
import com.example.harajtask.essential.extension.LiveDataExtension.asImmutable
import com.example.harajtask.feature.home.repository.HomeRepository
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : BaseViewModel() {

    private val _postData = MutableLiveData<List<Post>?>()
    val postData = _postData.asImmutable()

    fun getData(activity: Activity?, filter: String = "") = viewModelScope.launch(Dispatchers.IO) {
        val gson = Gson()
        this@HomeViewModel.repository.getData(
            activity,
            filter.lowercase(Locale.getDefault()),
            gson
        ).collect { taskResult ->
            if (taskResult.isSuccess) this@HomeViewModel._postData.postValue(taskResult.data)
            else this@HomeViewModel.mutableErrorMessage.postValue(taskResult.error)
        }
    }
}