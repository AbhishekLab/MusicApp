package com.university.listen.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseAdapter<in T : ViewDataBinding> : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder = BaseViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), viewType, parent, false
        )
    )

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    abstract fun getAnyForPosition(position: Int): Any
    //abstract fun getViewModel():T
    abstract fun getLayoutIdForPosition(position: Int): Int
}