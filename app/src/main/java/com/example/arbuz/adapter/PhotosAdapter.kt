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

class PhotosAdapter : ListAdapter<Photo, PhotosAdapter.PhotoViewHolder>(PhotosDiffCallback()) {
    private var photosList = listOf<Photo>()
    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view_photo)
        val textViewUser: TextView = itemView.findViewById(R.id.text_view_user)
        val textViewLikes: TextView = itemView.findViewById(R.id.text_view_likes)
        val textViewViews: TextView = itemView.findViewById(R.id.text_view_views)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = getItem(position)
        Glide.with(holder.imageView.context)
            .load(photo.webformatURL)
            .into(holder.imageView)
        holder.textViewUser.text = "User: ${photo.user}"
        holder.textViewLikes.text = "Likes: ${photo.likes}"
        holder.textViewViews.text = "Views: ${photo.views}"
    }

    fun filter(query: String) {
        photosList = currentList.filter { it.user.contains(query, true) }
        submitList(photosList)
    }
}
