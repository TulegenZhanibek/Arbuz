package com.example.arbuz.fragment

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arbuz.R
import com.example.arbuz.adapter.PhotosAdapter
import com.example.arbuz.databinding.FragmentPhotosBinding
import com.example.arbuz.entity.Photo
import com.example.arbuz.model.PhotosViewModel
import com.example.arbuz.model.SharedViewModel

class PhotosFragment : Fragment() {
    private lateinit var binding: FragmentPhotosBinding
    private val viewModel: PhotosViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var photosAdapter: PhotosAdapter
    private lateinit var searchPhotos: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhotosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView = view.findViewById(R.id.recycler_view_photos)
        searchPhotos = view.findViewById(R.id.search_photos)

        setupRecyclerView()
        observeViewModel()
        setupSearch()
    }

    private fun setupRecyclerView() {
        photosAdapter = PhotosAdapter(
            { photo ->
                sharedViewModel.addPhoto(photo)
            },
            { photo ->
                sharedViewModel.addPhoto(photo)
            }
        )
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = photosAdapter
        }
    }




    private fun observeViewModel() {
        viewModel.photos.observe(viewLifecycleOwner, Observer { photos ->
            binding.progressBarPopular.visibility = View.GONE
            photosAdapter.submitList(photos)
        })
    }

    private fun setupSearch() {
        searchPhotos.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterPhotos(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun filterPhotos(query: String) {
        val filteredList = viewModel.photos.value?.filter {
            it.user.contains(query, true)
        }
        photosAdapter.submitList(filteredList)
    }
}
