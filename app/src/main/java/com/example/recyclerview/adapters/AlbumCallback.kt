package com.example.recyclerview.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerview.model.Album

class AlbumCallback: DiffUtil.ItemCallback<Album>() {

    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.name == newItem.name && oldItem.image == newItem.image
    }
}