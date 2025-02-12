package com.example.harajtask.feature.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.R
import com.example.harajtask.databinding.ItemHomeListingBinding
import com.example.harajtask.essential.data.Post

class HomeAdapter(
    private var itemList: List<Post>,
    private var clickCallback: (Int, Post) -> Unit
) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemHomeListingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setBinding(position: Int, post: Post, callback: (Int, Post) -> Unit) {
            binding.post = post
            binding.root.setOnClickListener { callback.invoke(position, post) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_home_listing,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setBinding(position, itemList[position], clickCallback)
    }

    override fun getItemCount() = itemList.size

    fun updateList(list: List<Post>) {
        val diffCallback = DiffCallback(this.itemList, list)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.itemList = list
        diffResult.dispatchUpdatesTo(this)

    }
}