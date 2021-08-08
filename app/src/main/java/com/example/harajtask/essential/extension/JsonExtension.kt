package com.example.harajtask.essential.extension

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object JsonExtension {

    inline fun <reified T> T.toJsonString(gson: Gson): String = gson.toJson(this)

    inline fun <reified T> String.toDataClass(gson: Gson): T = gson.fromJson(this, T::class.java)

    inline fun <reified T> String.toArrayDataClass(gson: Gson) : List<T> {
        val type = TypeToken.getParameterized(List::class.java, T::class.java).type
        return gson.fromJson(this, type)
    }
}