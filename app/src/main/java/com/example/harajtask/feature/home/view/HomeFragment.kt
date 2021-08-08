package com.example.harajtask.feature.home.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.harajtask.R
import com.example.harajtask.databinding.FragmentHomeBinding
import com.example.harajtask.essential.base.BaseFragment
import com.example.harajtask.essential.data.Post
import com.example.harajtask.essential.extension.SearchViewExtension.onTextChange
import com.example.harajtask.feature.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()

    override val bindingId = R.layout.fragment_home

    private lateinit var adapter: HomeAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.setViewModelObserver()
        this.getInitialData()
        this.setupSearch()
    }

    private fun setupSearch() {
        this.binding?.homeToolbarLayoutSearch?.onTextChange { text ->
            val activity = this.activity ?: return@onTextChange
            this.viewModel.getData(activity, filter = text ?: "")
        }
    }

    private fun getInitialData() {
        val activity = this.activity ?: return
        this.viewModel.getData(activity)
    }

    private fun setViewModelObserver() {
        this.viewModel.postData.observe(this.viewLifecycleOwner, this::handlePostData)
    }

    private fun handlePostData(postData: List<Post>?) {
        if (::adapter.isInitialized.not()) adapter = HomeAdapter(
            itemList = postData ?: listOf(),
            clickCallback = this::handleAdapterClick
        )
        else adapter.updateList(postData ?: listOf())
        this.binding?.homeRecyclerView?.adapter = adapter
    }

    private fun handleAdapterClick(position: Int, post: Post) {
        this.binding?.root?.findNavController()?.navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(post))
    }
}