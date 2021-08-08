package com.example.harajtask.feature.detail.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.harajtask.R
import com.example.harajtask.databinding.FragmentDetailBinding
import com.example.harajtask.essential.base.BaseFragment
import com.example.harajtask.essential.data.Post
import com.example.harajtask.feature.detail.viewmodel.DetailViewModel

class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {
    override val bindingId = R.layout.fragment_detail

    override val viewModel: DetailViewModel by viewModels()

    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.setViewModelObserver()
        this.viewModel.setPostData(args.postData)
    }

    private fun setViewModelObserver() {
        this.viewModel.postData.observe(this.viewLifecycleOwner, this::handlePostData)
    }

    private fun handlePostData(post: Post) {
        this.binding?.post = post
    }
}