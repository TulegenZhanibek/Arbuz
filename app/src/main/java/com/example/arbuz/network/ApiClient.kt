package com.example.arbuz.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://unsplash.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
