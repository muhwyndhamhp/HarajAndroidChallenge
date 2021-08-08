package com.example.harajtask.essential.extension

import androidx.appcompat.widget.SearchView

object SearchViewExtension {
    fun SearchView?.onTextChange(callback: (String?) -> Unit) {
        this?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                callback.invoke(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                callback.invoke(newText)
                return true
            }

        })
    }
}