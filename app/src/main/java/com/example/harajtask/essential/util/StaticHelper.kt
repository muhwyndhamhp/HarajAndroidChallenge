package com.example.harajtask.essential.util

import android.app.Activity
import com.example.harajtask.essential.data.Post
import com.example.harajtask.essential.extension.IOExtension.getAssetJson
import com.example.harajtask.essential.extension.JsonExtension.toArrayDataClass
import com.google.gson.Gson
import javax.inject.Inject

class StaticHelper @Inject constructor() {
    fun getSystemTimeInMillis() = System.currentTimeMillis()

    fun getAssetJson(activity: Activity?, gson: Gson?) =
        if (gson != null)
            activity?.getAssetJson()?.toArrayDataClass<Post>(gson)
        else
            null
}