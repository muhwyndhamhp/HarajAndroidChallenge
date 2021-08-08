package com.example.harajtask.essential.util

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.harajtask.essential.extension.LongExtension.toCountDown
import io.muhwyndhamhp.currencymaster.essential.util.StaticHelper

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("app:setNetworkImage")
    fun setNetworkImage(view: View, url: String) {
        val imageView = view as? ImageView ?: return
        Glide.with(view).load(url).into(imageView)
    }

    @JvmStatic
    @BindingAdapter("app:setElapsedTime")
    fun setElapsedTime(view: View, time: Long) {
        val textView = view as? TextView ?: return
        val currentTime = StaticHelper().getSystemTimeInMillis()
        val elapsedTime = time.times(1000).minus(currentTime).toCountDown()
        textView.text = elapsedTime
    }
}