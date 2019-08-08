package com.university.listen.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast
import com.university.listen.di.component.ActivityComponent
import com.university.listen.di.component.DaggerActivityComponent
import com.university.listen.di.module.ActivityModule
import com.university.listen.permission.RuntimePermissionsActivity

abstract class BaseActivity<in T : ViewDataBinding> : RuntimePermissionsActivity() {


    private lateinit var mBinding: T

    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {

        activityComponent = DaggerActivityComponent.builder().appComponent((applicationContext as AppClass).appComponent)
            .activityModule(
                ActivityModule(this)
            ).build()
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, contentView())
        initUI(mBinding)
    }

    abstract fun contentView(): Int
    abstract fun initUI(binding: T)

    fun showToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()

    protected open fun
            fragmentTransaction(
        transactionType: Int,
        fragment: Fragment,
        container: Int,
        isAddToBackStack: Boolean,
        bundle: Bundle?
    ) {
        if (bundle != null) {
            fragment.arguments = bundle
        }

        val trans = supportFragmentManager.beginTransaction()
        when (transactionType) {
            ADD_FRAGMENT -> trans.add(container, fragment, fragment.javaClass.simpleName)
            REPLACE_FRAGMENT -> {
                trans.replace(container, fragment, fragment.javaClass.simpleName)
                if (isAddToBackStack) trans.addToBackStack(null)
            }
        }
        trans.commit()
    }

    companion object {
        const val ADD_FRAGMENT = 0
        const val REPLACE_FRAGMENT = 1
    }
}