package com.example.arbuz.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.arbuz.entity.Photo
import com.example.arbuz.entity.PhotosRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PhotosViewModel : ViewModel() {
    private val repository = PhotosRepository()

    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> get() = _photos

    suspend fun getPhotos(): List<Photo> {
        return withContext(Dispatchers.IO) {
            repository.getPhotos()
        }
    }
}
