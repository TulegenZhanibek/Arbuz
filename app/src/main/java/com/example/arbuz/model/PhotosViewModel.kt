package com.example.arbuz.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arbuz.entity.Photo
import com.example.arbuz.entity.PhotosRepository
import kotlinx.coroutines.launch

class PhotosViewModel : ViewModel() {
    private val repository = PhotosRepository()

    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> get() = _photos

    init {
        fetchPhotosData()
    }

    fun fetchPhotosData() {
        viewModelScope.launch {
            try {
                val response = repository.getPhotos()
                _photos.value = response
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

//    fun searchPhotos(query: String) {
//        viewModelScope.launch {
//            try {
//                val response = repository.searchPhotos(query)
//                _photos.value = response
//            } catch (e: Exception) {
//                // Handle error
//            }
//        }
//    }
}
