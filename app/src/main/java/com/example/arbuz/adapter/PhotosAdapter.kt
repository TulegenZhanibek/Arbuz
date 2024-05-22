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

class PhotosAdapter(
    private val onPhotoClicked: (Photo) -> Unit,
    private val onAddToCartClicked: (Photo) -> Unit
) : ListAdapter<Photo, PhotosAdapter.PhotoViewHolder>(PhotosDiffCallback()) {

    class PhotoViewHolder(itemView: View, val onPhotoClicked: (Photo) -> Unit, val onAddToCartClicked: (Photo) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view_photo)
        val textViewUser: TextView = itemView.findViewById(R.id.text_view_user)
        val textViewLikes: TextView = itemView.findViewById(R.id.text_view_likes)
        val textViewViews: TextView = itemView.findViewById(R.id.text_view_views)
        val addToCartButton: ImageView = itemView.findViewById(R.id.add_in_cart)

        fun bind(photo: Photo) {
            Glide.with(imageView.context)
                .load(photo.webformatURL)
                .into(imageView)
            textViewUser.text = "User: ${photo.user}"
            textViewLikes.text = "Likes: ${photo.likes}"
            textViewViews.text = "Views: ${photo.views}"

            itemView.setOnClickListener {
                onPhotoClicked(photo)
            }

            addToCartButton.setOnClickListener {
                onAddToCartClicked(photo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(view, onPhotoClicked, onAddToCartClicked)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = getItem(position)
        holder.bind(photo)
    }
}

