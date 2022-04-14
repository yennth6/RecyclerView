package com.example.recyclerview.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = "https://6218ef9681d4074e859c7eb8.mockapi.io/"

    private fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val retrofit : ApiInterface = getRetrofit().create(ApiInterface::class.java)
}