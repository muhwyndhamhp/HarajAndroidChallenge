package com.example.harajtask.essential.extension

import android.app.Activity
import java.io.IOException

object IOExtension {

    @Throws(IOException::class)
    fun Activity.getAssetJson(): String {
        return try {
            val inputStream = this.assets.open("data.json")
            val buffer = byteArrayOf()
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
            throw e
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }
}