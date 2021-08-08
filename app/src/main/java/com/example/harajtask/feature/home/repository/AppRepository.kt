package com.example.harajtask.feature.home.repository

import android.app.Activity
import com.example.harajtask.essential.base.TaskResult
import com.example.harajtask.essential.extension.IOExtension.getAssetJson
import com.example.harajtask.essential.extension.JsonExtension.toDataClass
import com.example.harajtask.essential.data.Post
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AppRepository {
    fun getData(activity: Activity?, filter: String, gson: Gson): Flow<TaskResult<List<Post>?>> =
        flow {
            val result = activity?.getAssetJson()?.toDataClass<List<Post>>(gson)
            emit(TaskResult.success(result))
        }.catch { e ->
            emit(TaskResult.failure(e))
        }.flowOn(Dispatchers.IO)
}