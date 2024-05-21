package com.example.arbuz.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arbuz.R
import com.example.arbuz.adapter.PhotosAdapter
import com.example.arbuz.model.PhotosViewModel

class PhotosFragment : Fragment() {

    private val viewModel: PhotosViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var photosAdapter: PhotosAdapter

    private fun navigateToCartFragment() {
        // Use the NavController to navigate to CartFragment
        findNavController().navigate(R.id.action_photosFragment_to_cartFragment)
    }
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

//        search_photos.addTextChangedListener { text ->
//            val query = text.toString()
//            viewModel.searchPhotos(query)
//        }
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
}
