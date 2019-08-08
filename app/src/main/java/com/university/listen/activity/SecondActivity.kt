package com.university.listen.activity

import com.university.listen.R
import com.university.listen.adapter.AdapterDemo
import com.university.listen.base.BaseActivity
import com.university.listen.databinding.ActivitySecondBinding
import com.university.listen.model.DataModel
import javax.inject.Inject

class SecondActivity : BaseActivity<ActivitySecondBinding>() {

    lateinit var mBinding: ActivitySecondBinding

    @Inject
    lateinit var adapterDemo: AdapterDemo

    override fun onPermissionsGranted(requestCode: Int) {

    }

    override fun contentView() = R.layout.activity_second

    override fun initUI(binding: ActivitySecondBinding) {
        activityComponent.inject(this)
        mBinding = binding

        mBinding.rvDemo.apply {
            adapterDemo.list = DataModel.secondAdapterDemo(context)
            adapter = adapterDemo
        }
    }
}