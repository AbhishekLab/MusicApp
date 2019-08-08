package com.university.listen.base

import android.app.Application
import com.university.listen.di.component.AppComponent
import com.university.listen.di.component.DaggerAppComponent
import com.university.listen.di.module.AppModule

class AppClass : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}