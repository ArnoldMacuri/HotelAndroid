package com.arnold.cursocompose.data.repository

import com.arnold.cursocompose.data.network.LoginService

class LoginRepository {
    private val api = LoginService()

    suspend fun doLogin(user:String, password:String):Boolean{
        return api.doLogin(user, password)
    }
}