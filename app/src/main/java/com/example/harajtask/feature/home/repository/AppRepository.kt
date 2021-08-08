package com.example.harajtask.feature.home.repository

import android.app.Activity
import com.example.harajtask.essential.base.TaskResult
import com.example.harajtask.essential.data.Post
import com.example.harajtask.essential.extension.IOExtension.getAssetJson
import com.example.harajtask.essential.extension.JsonExtension.toDataClass
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.*

class AppRepository {
    fun getData(activity: Activity?, filter: String, gson: Gson): Flow<TaskResult<List<Post>?>> =
        flow {
            var result = activity?.getAssetJson()?.toDataClass<List<Post>>(gson)
            result = if (filter.isEmpty()) result
            else result?.filter { post ->
                post.body?.lowercase(Locale.getDefault())?.contains(filter) == true
                        || post.city?.lowercase(Locale.getDefault())?.contains(filter) == true
                        || post.title?.lowercase(Locale.getDefault())?.contains(filter) == true
                        || post.username?.lowercase(Locale.getDefault())
                    ?.contains(filter) == true
            }
            emit(TaskResult.success(result))
        }.catch { e ->
            emit(TaskResult.failure(e))
        }.flowOn(Dispatchers.IO)
}
