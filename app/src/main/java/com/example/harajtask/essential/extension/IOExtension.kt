package com.example.harajtask.essential.extension

import android.app.Activity

object IOExtension {

    fun Activity.getAssetJson(): String {
        return try {
            val inputStream = this.assets.open("data.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charsets.UTF_8)
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }
}