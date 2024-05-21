package com.example.arbuz.entity

import com.google.gson.annotations.SerializedName

data class PixabayResponse(
    @SerializedName("totalHits") val totalHits: Int,
    @SerializedName("hits") val hits: List<Photo>
)

data class Photo(
    @SerializedName("id") val id: Int,
    @SerializedName("views") val views: Int,
    @SerializedName("likes") val likes: Int,
    @SerializedName("user") val user: String,
    @SerializedName("webformatURL") val webformatURL: String
)
