package com.example.arbuz.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arbuz.adapter.CartAdapter
import com.example.arbuz.databinding.FragmentCartBinding
import com.example.arbuz.model.SharedViewModel

class CartFragment : Fragment() {
    private lateinit var viewModel: SharedViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var cartAdapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCartBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        recyclerView = binding.recyclerViewCart
        setupRecyclerView()

        viewModel.selectedPhotos.observe(viewLifecycleOwner, { photos ->
            cartAdapter.submitList(photos.toList())
            binding.progressBarPopular.visibility = View.GONE
        })

        return view
    }

    private fun setupRecyclerView() {
        cartAdapter = CartAdapter(viewModel)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = cartAdapter
        }
    }
}
