package com.example.harajtask.essential.extension

import com.google.gson.Gson

object JsonExtension {

    inline fun <reified T> T.toJsonString(gson: Gson): String = gson.toJson(this)

    inline fun <reified T> String.toDataClass(gson: Gson): T = gson.fromJson(this, T::class.java)

}