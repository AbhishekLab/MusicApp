package com.university.listen.di.module

import android.content.Context
import android.content.SharedPreferences
import com.university.listen.constant.Constant
import com.university.listen.data.prefrence.PrefsClass
import com.university.listen.data.prefrence.PrefsFace
import dagger.Module
import dagger.Provides

@Module
class AppModule(val applicationContext: Context) {

    @Provides
    fun providePrefs(): PrefsFace {
        val sharedPreferences: SharedPreferences =
            applicationContext.getSharedPreferences(Constant.SHAREDPREFRENCE, Context.MODE_PRIVATE)
        return PrefsClass(sharedPreferences)
    }

}