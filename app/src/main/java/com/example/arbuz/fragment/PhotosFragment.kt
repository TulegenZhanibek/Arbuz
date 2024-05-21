package com.example.arbuz.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arbuz.R
import com.example.arbuz.adapter.PhotosAdapter
import com.example.arbuz.entity.Photo
import com.example.arbuz.model.PhotosViewModel
import kotlinx.coroutines.launch

class PhotosFragment : Fragment() {

    private val viewModel: PhotosViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var photosAdapter: PhotosAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view_photos)
        setupRecyclerView()
        observeViewModel()

        fetchPhotosData()
    }

    private fun setupRecyclerView() {
        photosAdapter = PhotosAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = photosAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.photos.observe(viewLifecycleOwner, Observer { photos ->
            photosAdapter.submitList(photos)
        })
    }

    private fun fetchPhotosData() {
        lifecycleScope.launch {
            try {
                val response = viewModel.getPhotos()
                if (response.isNotEmpty()) {
                    photosAdapter.submitList(response)
                }
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }
}
