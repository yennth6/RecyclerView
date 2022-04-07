package com.example.recyclerview.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.Toaster
import com.example.recyclerview.model.Banner
import com.example.recyclerview.model.Song
import com.example.recyclerview.view_holder.ItemSongViewHolder
import com.example.recyclerview.view_holder.ItemTextViewHolder
import com.example.recyclerview.view_holder.ListAlbumViewHolder
import com.example.recyclerview.view_holder.ListBannerViewHolder

class MainAdapter(private val mainList: ArrayList<Any>, private val toaster: Toaster) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var albumAdapter: ListAlbumAdapter? = null
    override fun getItemViewType(position: Int): Int {
        when (mainList[position]) {
            is ArrayList<*> -> {
                return if ((mainList[position] as ArrayList<*>).firstOrNull() is Banner) {
                    ARRAY_BANNER
                } else ARRAY_ALBUM
            }
            is Song -> {
                return SONG
            }
            is String -> {
                return TEXT
            }
        }
        return -1
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        when (viewType) {
            ARRAY_BANNER -> {
                val itemListBanner =
                    layoutInflater.inflate(R.layout.item_list_banners, parent, false)
                return ListBannerViewHolder(itemListBanner)
            }
            ARRAY_ALBUM -> {
                val itemListAlbum =
                    layoutInflater.inflate(R.layout.item_list_albums, parent, false)
                return ListAlbumViewHolder(itemListAlbum)
            }
            SONG -> {
                val itemSong =
                    layoutInflater.inflate(R.layout.item_song, parent, false)
                val holder = ItemSongViewHolder(itemSong)
                holder.textDelete.setOnClickListener {
                    Log.d("MainAdapter", "${holder.adapterPosition}")
                    mainList.removeAt(holder.adapterPosition)
                    this.notifyItemRemoved(holder.adapterPosition)
                    this.notifyItemChanged(mainList.size - 1, true)
                }
                holder.itemView.setOnClickListener {
                    toaster.showToast(holder.adapterPosition, null)
                }
                return holder
            }
            TEXT -> {
                val itemText =
                    layoutInflater.inflate(R.layout.item_text, parent, false)
                return ItemTextViewHolder(itemText)
            }
        }
        val itemText =
            layoutInflater.inflate(R.layout.item_text, parent, false)
        return ItemTextViewHolder(itemText)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)) {
            TEXT -> {
                val textViewHolder = holder as ItemTextViewHolder
                textViewHolder.textView.text = mainList[position] as String
            }
            SONG -> {
                val songViewHolder = holder as ItemSongViewHolder
                val song = mainList[position] as Song
                songViewHolder.imageSong.setImageResource(song.image)
                songViewHolder.textSongName.text = song.name
            }
            ARRAY_BANNER -> {
                val bannerViewHolder = holder as ListBannerViewHolder
                val bannerList = mainList[position] as ArrayList<*>
                val layoutManager = LinearLayoutManager(bannerViewHolder.recyclerView.context,
                    LinearLayoutManager.HORIZONTAL, false)
                bannerViewHolder.recyclerView.layoutManager = layoutManager

                val adapter = ListBannerAdapter(bannerList, toaster,
                    bannerViewHolder.adapterPosition)
                bannerViewHolder.recyclerView.adapter = adapter
            }
            ARRAY_ALBUM -> {
                val albumViewHolder = holder as ListAlbumViewHolder
                val albumList = mainList[position] as ArrayList<*>
                val layoutManager = GridLayoutManager(albumViewHolder.recyclerView.context, 2)
                albumViewHolder.recyclerView.layoutManager = layoutManager

                albumAdapter = ListAlbumAdapter(albumList, toaster, albumViewHolder.adapterPosition)
                albumViewHolder.recyclerView.adapter = albumAdapter
            }

        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty()) {
            if (payloads[0] is Boolean) {
                albumAdapter?.parentPosition = albumAdapter?.parentPosition?.minus(1)!!
            }
        }
        else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    override fun getItemCount(): Int {
        return mainList.size
    }

    companion object {
        private  const val ARRAY_BANNER = 0
        private const val ARRAY_ALBUM = 1
        private const val SONG = 2
        private const val TEXT = 3
    }
}