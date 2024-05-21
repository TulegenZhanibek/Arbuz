package com.example.arbuz.network

import com.example.arbuz.entity.PixabayResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/api/")
    suspend fun getPhotos(
        @Query("key") apiKey: String,
        @Query("image_type") imageType: String = "photo"
    ): PixabayResponse
}
