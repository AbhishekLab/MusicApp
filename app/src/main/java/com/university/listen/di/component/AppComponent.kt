package com.university.listen.di.component

import com.university.listen.data.prefrence.PrefsFace
import com.university.listen.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun providePrefsFace():PrefsFace
}