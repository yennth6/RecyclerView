package com.example.recyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.Toaster
import com.example.recyclerview.data.MainViewModel
import com.example.recyclerview.model.Album

class ListAlbumAdapter(private val albumList: ArrayList<*>,
                       private val toaster: Toaster,
                       private val parentPosition: Int,
                       private val viewModel: MainViewModel) :
    RecyclerView.Adapter<ListAlbumAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val albumImage: ImageView = view.findViewById(R.id.image_album)
        val albumName: TextView = view.findViewById(R.id.text_album_name)
        private val textDelete: TextView = view.findViewById(R.id.text_delete_album)

        init {
            textDelete.setOnClickListener {
//                albumList.removeAt(adapterPosition)
//                notifyItemRemoved(adapterPosition)
                viewModel.deleteItem(parentPosition, adapterPosition)
            }
            itemView.setOnClickListener {
                toaster.showToast(parentPosition, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_album, parent, false)

        return ViewHolder(view)
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