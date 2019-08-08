package com.university.listen.base

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.university.listen.di.component.ActivityComponent
import com.university.listen.di.component.DaggerActivityComponent
import com.university.listen.di.module.ActivityModule

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    lateinit var binding: T
    abstract fun getContentView(): Int
    lateinit var activityComponent: ActivityComponent

    abstract fun initView(binding: T)

    override fun onAttach(context: Context?) {
        activityComponent = DaggerActivityComponent.builder().appComponent((activity as AppClass).appComponent)
            .activityModule(
                ActivityModule(activity!!)
            ).build()
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, getContentView(), container, false)
        initView(binding)
        return binding.root
    }

    fun showToast(message: String) = Toast.makeText(activity, message, Toast.LENGTH_LONG).show()

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

        val trans = activity!!.supportFragmentManager.beginTransaction()
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