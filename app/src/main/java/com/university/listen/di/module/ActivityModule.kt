package com.university.listen.di.module

import android.content.Context
import com.university.listen.DemoFragment
import com.university.listen.adapter.AdapterDemo
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(val activityContext:Context) {

    @Provides
    fun provideMyAdapter(): DemoFragment {
        return DemoFragment()
    }

    @Provides
    fun adapterDemo(): AdapterDemo {
        return AdapterDemo(context = activityContext)
    }
}