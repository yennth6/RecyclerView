package com.example.recyclerview.view_holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.adapters.OnItemHomeClickListener

class ItemSongViewHolder(view: View, listener: OnItemHomeClickListener) : RecyclerView.ViewHolder(view) {
    val imageSong: ImageView = view.findViewById(R.id.image_song)
    val textSongName: TextView = view.findViewById(R.id.text_song_name)
    private val textDelete: TextView = view.findViewById(R.id.text_delete_song)

    init {
        textDelete.setOnClickListener {
            listener.onClickDeleteItem(adapterPosition, -1)
        }
        itemView.setOnClickListener {
            listener.onClickItem(adapterPosition, -1)
        }
    }

}
