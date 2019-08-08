package com.university.listen.data.prefrence

interface PrefsFace {

    fun saveUserName(userName: String)
    fun savePassword(password: String)
    fun saveAccessToken(accessToken:String)
    fun getUsername(): String
    fun getPassword(): String
}