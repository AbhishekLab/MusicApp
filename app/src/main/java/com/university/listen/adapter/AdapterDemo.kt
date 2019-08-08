package com.university.listen.adapter

import com.university.listen.R
import com.university.listen.activity.FirstActivity
import com.university.listen.base.BaseAdapter
import com.university.listen.base.BaseViewHolder
import com.university.listen.databinding.ItemsDemoBinding
import com.university.listen.model.DataModel

class AdapterDemo(val context: Any) : BaseAdapter<ItemsDemoBinding>() {

    lateinit var mBinding: ItemsDemoBinding
    override fun getAnyForPosition(position: Int) = DataModel.dataAdapterDemo(context as FirstActivity)[position]

    override fun getLayoutIdForPosition(position: Int) = R.layout.items_demo

    override fun getItemCount() = DataModel.dataAdapterDemo(context as FirstActivity).size

    override fun onBindViewHolder(p0: BaseViewHolder, p1: Int) {
        mBinding = p0.bind() as ItemsDemoBinding

        mBinding.apply {
            this.activity = context as FirstActivity
            this.position = p1
            mBinding.txtTitle.text = DataModel.dataAdapterDemo(context).toString()
        }

    }
}