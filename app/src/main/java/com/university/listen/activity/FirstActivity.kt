package com.university.listen.activity

import android.content.Intent
import android.util.Log.d
import com.university.listen.R
import com.university.listen.adapter.AdapterDemo
import com.university.listen.base.BaseActivity
import com.university.listen.data.prefrence.PrefsFace
import com.university.listen.databinding.ActivityFirstBinding
import javax.inject.Inject

class FirstActivity : BaseActivity<ActivityFirstBinding>() {

    @Inject
    lateinit var prefs: PrefsFace

    @Inject
    lateinit var adapterDemo: AdapterDemo


    lateinit var mBinding: ActivityFirstBinding

    override fun onPermissionsGranted(requestCode: Int) {
    }

    override fun contentView() = R.layout.activity_first

    override fun initUI(binding: ActivityFirstBinding) {
        activityComponent.inject(this)
        mBinding = binding

        prefs.saveUserName("Abhishek kumar")
        d("USERDATA", prefs.getUsername())

        mBinding.rvDemo.apply {
            adapter = adapterDemo
        }
    }

    fun onItemClick(position: Int) {
        startActivity(Intent(this, SecondActivity::class.java))
    }
}
