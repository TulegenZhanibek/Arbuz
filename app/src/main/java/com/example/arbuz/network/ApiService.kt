package com.example.arbuz.network

import com.example.arbuz.entity.Photo
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/photos/random")
    suspend fun getRandomPhoto(
        @Query("client_id") clientId: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<Photo>
}
