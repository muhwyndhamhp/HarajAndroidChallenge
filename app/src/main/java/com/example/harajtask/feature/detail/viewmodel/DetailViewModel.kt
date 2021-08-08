package com.example.harajtask.feature.detail.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.harajtask.essential.base.BaseViewModel
import com.example.harajtask.essential.data.Post
import com.example.harajtask.essential.extension.LiveDataExtension.asImmutable
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : BaseViewModel() {
    private val _postData = MutableLiveData<Post>()
    val postData = _postData.asImmutable()

    fun setPostData(post: Post?) {
        if (post != null)
            this._postData.postValue(post)
    }
}