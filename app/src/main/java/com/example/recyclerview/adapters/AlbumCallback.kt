package com.example.recyclerview.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerview.data.model.Album

class AlbumCallback : DiffUtil.ItemCallback<Album>() {

    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.image == newItem.image
                && oldItem.name == newItem.name
                && oldItem.totalSong == newItem.totalSong
    }
}