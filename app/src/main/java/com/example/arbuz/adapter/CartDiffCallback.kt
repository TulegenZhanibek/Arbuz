package com.example.arbuz.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.arbuz.entity.Photo

class CartDiffCallback : DiffUtil.ItemCallback<Pair<Photo, Int>>() {
    override fun areItemsTheSame(oldItem: Pair<Photo, Int>, newItem: Pair<Photo, Int>): Boolean {
        return oldItem.first.id == newItem.first.id
    }

    override fun areContentsTheSame(oldItem: Pair<Photo, Int>, newItem: Pair<Photo, Int>): Boolean {
        return oldItem == newItem
    }
}
