package com.university.listen.di.component

import com.university.listen.activity.FirstActivity
import com.university.listen.activity.SecondActivity
import com.university.listen.di.annotation.ActivityScope
import com.university.listen.di.module.ActivityModule
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class] , dependencies = [AppComponent::class])
interface ActivityComponent : AppComponent {

    fun inject(firstActivity: FirstActivity)
    fun inject(secondActivity: SecondActivity)


}