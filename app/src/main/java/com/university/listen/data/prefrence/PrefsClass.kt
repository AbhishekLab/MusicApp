package com.university.listen.data.prefrence

import android.content.SharedPreferences
import com.university.listen.constant.Constant
import javax.inject.Inject

class PrefsClass @Inject constructor(val sharedPrefs:SharedPreferences) :PrefsFace {

    override fun saveUserName(userName: String) {
        sharedPrefs.edit().putString(Constant.USERNAME,userName).apply()
    }

    override fun savePassword(password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveAccessToken(accessToken: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUsername(): String {
        return sharedPrefs.getString(Constant.USERNAME,"")!!
    }

    override fun getPassword(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}