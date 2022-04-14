package com.example.recyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview.R
import com.example.recyclerview.data.model.Album

class ListAlbumAdapter(val listener: MainAdapter.OnNestedItemClickListener) :
    ListAdapter<Album, ListAlbumAdapter.ViewHolder>(AlbumCallback()) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val albumImage: ImageView = view.findViewById(R.id.image_album)
        val albumName: TextView = view.findViewById(R.id.text_album_name)
        private val textDelete: TextView = view.findViewById(R.id.text_delete_album)

        init {
            textDelete.setOnClickListener {
                listener.onItemClickDelete(adapterPosition)
            }
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_album, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = getItem(position)
        Glide.with(holder.albumImage.context).load(album.image).into(holder.albumImage)
        holder.albumName.text = album.name
    }
}