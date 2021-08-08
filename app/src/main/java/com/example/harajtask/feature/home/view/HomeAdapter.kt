package com.example.harajtask.feature.home.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.R
import com.example.harajtask.databinding.ItemHomeListingBinding
import com.example.harajtask.essential.data.Post

class HomeAdapter(private var itemList: List<Post>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemHomeListingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setBinding(post: Post) {
            binding.post = post
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
        holder.setBinding(itemList[position])
    }

    override fun getItemCount() = itemList.size


    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<Post>) {
        if (list.isNullOrEmpty().not()) {
            val diffCallback = DiffCallback(this.itemList, list)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            this.itemList = list
            diffResult.dispatchUpdatesTo(this)
        }
        
    }
}