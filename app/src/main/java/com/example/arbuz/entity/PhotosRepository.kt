package com.example.arbuz.entity

import com.example.arbuz.network.ApiClient

class PhotosRepository {
    suspend fun getPhotos(): List<Photo> {
        return try {
            val response = ApiClient.apiService.getRandomPhoto("GO0AsARhM8Rg6T_CXNXUjakipWhMX5wlqbVHSvjBHVg", 1, 1)
            if (response.isNotEmpty()) {
                response
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}
