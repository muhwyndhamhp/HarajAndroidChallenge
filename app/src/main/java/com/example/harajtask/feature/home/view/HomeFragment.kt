package com.example.harajtask.feature.home.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.harajtask.R
import com.example.harajtask.databinding.FragmentHomeBinding
import com.example.harajtask.essential.base.BaseFragment
import com.example.harajtask.essential.data.Post
import com.example.harajtask.feature.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()

    override val bindingId = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.setViewModelObservers()
        this.getInitialData()
    }

    private fun getInitialData() {
        val activity = this.activity ?: return
        this.viewModel.getData(activity)
    }

    private fun setViewModelObservers() {
        this.viewModel.postData.observe(this.viewLifecycleOwner, this::handlePostData)
    }

    private fun handlePostData(postData: List<Post>?) {
        val context = this.context ?: return
        val toast = Toast.makeText(context, postData.toString(), Toast.LENGTH_SHORT)
        toast.show()
    }
}