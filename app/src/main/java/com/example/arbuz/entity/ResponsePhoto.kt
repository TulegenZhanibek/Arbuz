package com.example.arbuz.entity

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id") val id: String,
    @SerializedName("urls") val urls: PhotoUrls
)

data class PhotoUrls(
    @SerializedName("small") val small: String
)
