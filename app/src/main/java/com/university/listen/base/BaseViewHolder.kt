package com.university.listen.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

class BaseViewHolder(viewDataBinding: ViewDataBinding) : RecyclerView.ViewHolder(viewDataBinding.root) {

    private val binding: ViewDataBinding?
    init {
        this.binding=viewDataBinding
    }


    fun bind(): ViewDataBinding?{
        //binding?.setVariable(BR.,any)
        //binding?.setVariable(BR.viewModel,viewModel)
        binding?.executePendingBindings()
        return binding
    }
}
