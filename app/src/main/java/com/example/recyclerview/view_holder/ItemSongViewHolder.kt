package com.example.recyclerview.view_holder

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.Toaster
import com.example.recyclerview.adapters.MainAdapter
import com.example.recyclerview.data.MainViewModel

class ItemSongViewHolder(view: View, toaster: Toaster, viewModel: MainViewModel) : RecyclerView.ViewHolder(view) {
    val imageSong: ImageView = view.findViewById(R.id.image_song)
    val textSongName: TextView = view.findViewById(R.id.text_song_name)
    private val textDelete: TextView = view.findViewById(R.id.text_delete_song)

    init {
        textDelete.setOnClickListener {
            Log.d("MainAdapter", "$adapterPosition")
            viewModel.deleteItem(adapterPosition, null)
//            val mainList = adapter.getListItems()
//            mainList.removeAt(adapterPosition)
//            adapter.notifyItemRemoved(adapterPosition)
//            adapter.notifyItemChanged(mainList.size - 1, true)
        }
        itemView.setOnClickListener {
            toaster.showToast(adapterPosition, null)
        }
    }

}
