package com.example.harajtask.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.TimeUnit

/**
 * @see getOrAwaitValue is an extension used as way to await value of a LiveData as
 * it being fetched Asynchronously
 */
object UnitTestExtension {

    fun <T> LiveData<T>.getOrAwaitValue(
        time: Long = 60,
        timeUnit: TimeUnit = TimeUnit.SECONDS
    ): T {
        var data: T? = null
        val latch = java.util.concurrent.CountDownLatch(1)
        val observer = object : Observer<T> {
            override fun onChanged(o: T?) {
                this@getOrAwaitValue.removeObserver(this)

                data = o
                latch.countDown()
            }
        }

        this.observeForever(observer)

        // Don't wait indefinitely if the LiveData is not set.
        if (!latch.await(time, timeUnit)) {
            throw java.util.concurrent.TimeoutException("LiveData value was never set.")
        }

        @Suppress("UNCHECKED_CAST")
        return data as T
    }

}