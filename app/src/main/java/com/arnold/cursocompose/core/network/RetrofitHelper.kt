package com.arnold.cursocompose.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://localhost:8083/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}