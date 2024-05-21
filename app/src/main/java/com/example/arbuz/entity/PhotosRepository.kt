package com.example.arbuz.entity

import com.example.arbuz.network.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PhotosRepository {
    suspend fun getPhotos(): List<Photo> {
        return withContext(Dispatchers.IO) {
            try {
                val response = ApiClient.apiService.getPhotos("43984008-6501997e20fe4bc33324aa4b0", "photo")
                if (response.hits.isNotEmpty()) {
                    response.hits
                } else {
                    emptyList()
                }
            } catch (e: Exception) {
                emptyList()
            }
        }
    }
}
