package com.example.recyclerview.view_holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R

class ListAlbumViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_album)
}
