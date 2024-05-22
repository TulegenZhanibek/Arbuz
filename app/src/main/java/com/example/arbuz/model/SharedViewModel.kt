package com.example.arbuz.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.arbuz.entity.Photo

class SharedViewModel : ViewModel() {
    private val _selectedPhotos = MutableLiveData<Map<Photo, Int>>(emptyMap())
    val selectedPhotos: LiveData<Map<Photo, Int>> get() = _selectedPhotos

    fun addPhoto(photo: Photo) {
        val currentPhotos = _selectedPhotos.value ?: emptyMap()
        val currentQuantity = currentPhotos[photo] ?: 0
        val updatedPhotos = currentPhotos.toMutableMap()
        updatedPhotos[photo] = currentQuantity + 1
        _selectedPhotos.value = updatedPhotos
    }

    fun removePhoto(photo: Photo) {
        val currentPhotos = _selectedPhotos.value ?: emptyMap()
        val currentQuantity = currentPhotos[photo] ?: 0
        if (currentQuantity > 1) {
            val updatedPhotos = currentPhotos.toMutableMap()
            updatedPhotos[photo] = currentQuantity - 1
            _selectedPhotos.value = updatedPhotos
        } else {
            val updatedPhotos = currentPhotos.toMutableMap()
            updatedPhotos.remove(photo)
            _selectedPhotos.value = updatedPhotos
        }
    }
}
