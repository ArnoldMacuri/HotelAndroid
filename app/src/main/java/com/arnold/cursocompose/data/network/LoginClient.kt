package com.arnold.cursocompose.data.network

import com.arnold.cursocompose.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {
    @GET("api/usuarios")
    suspend fun doLogin(): Response<LoginResponse>
}