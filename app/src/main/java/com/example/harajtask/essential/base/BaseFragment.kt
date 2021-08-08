package com.example.harajtask.essential.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.harajtask.BR

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : Fragment() {

    open var binding: T? = null
    protected open val bindingId: Int? = null

    protected open val viewModel: V? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindingId =
            bindingId ?: return super.onCreateView(
                inflater,
                container,
                savedInstanceState
            )

        binding = DataBindingUtil.inflate(inflater, bindingId, container, false)
        binding?.setVariable(BR.fragment, this)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.viewModel?.errorMessage?.observe(this.viewLifecycleOwner, ::handleErrorMessage)
    }

    private fun handleErrorMessage(message: String?) {
        val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        toast.show()
    }
}