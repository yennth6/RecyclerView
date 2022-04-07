package com.example.recyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.Toaster
import com.example.recyclerview.model.Album

class ListAlbumAdapter(private val albumList: ArrayList<*>,
                       private val toaster: Toaster,
                       var parentPosition: Int) :
    RecyclerView.Adapter<ListAlbumAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val albumImage: ImageView = view.findViewById(R.id.image_album)
        val albumName: TextView = view.findViewById(R.id.text_album_name)
        val textDelete: TextView = view.findViewById(R.id.text_delete_album)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_album, parent, false)

        val holder =  ViewHolder(view)
        holder.textDelete.setOnClickListener {
            albumList.removeAt(holder.adapterPosition)
            this.notifyItemRemoved(holder.adapterPosition)
        }
        holder.itemView.setOnClickListener {
            toaster.showToast(parentPosition, holder.adapterPosition)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = albumList[position] as Album
        holder.albumImage.setImageResource(album.image)
        holder.albumName.text = album.name
    }

    override fun getItemCount(): Int {
        return albumList.size
    }
}