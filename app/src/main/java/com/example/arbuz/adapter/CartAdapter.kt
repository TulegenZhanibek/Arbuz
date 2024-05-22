package com.example.arbuz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.arbuz.R
import com.example.arbuz.entity.Photo
import com.example.arbuz.model.SharedViewModel

class CartAdapter(
    private val viewModel: SharedViewModel
) : ListAdapter<Pair<Photo, Int>, CartAdapter.CartViewHolder>(CartDiffCallback()) {

    class CartViewHolder(itemView: View, val viewModel: SharedViewModel) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view_photo)
        val textViewUser: TextView = itemView.findViewById(R.id.text_view_user)
        val textViewLikes: TextView = itemView.findViewById(R.id.text_view_likes)
        val textViewViews: TextView = itemView.findViewById(R.id.text_view_views)
        val textViewDecimal: TextView = itemView.findViewById(R.id.textView_decimal)
        val textViewPlus: TextView = itemView.findViewById(R.id.textView_plus)
        val textViewMinus: TextView = itemView.findViewById(R.id.textView_minus)

        fun bind(photo: Photo, quantity: Int) {
            Glide.with(imageView.context)
                .load(photo.webformatURL)
                .into(imageView)
            textViewUser.text = "User: ${photo.user}"
            textViewLikes.text = "Likes: ${photo.likes}"
            textViewViews.text = "Views: ${photo.views}"
            textViewDecimal.text = quantity.toString()

            textViewPlus.setOnClickListener {
                viewModel.addPhoto(photo)
            }

            textViewMinus.setOnClickListener {
                viewModel.removePhoto(photo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view, viewModel)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val (photo, quantity) = getItem(position)
        holder.bind(photo, quantity)
    }
}
