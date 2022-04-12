package com.example.recyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.utils.*
import com.example.recyclerview.view_holder.ItemSongViewHolder
import com.example.recyclerview.view_holder.ItemTextViewHolder
import com.example.recyclerview.view_holder.ListAlbumViewHolder
import com.example.recyclerview.view_holder.ListBannerViewHolder

class MainAdapter(private val onItemHome: OnItemHomeClickListener) :
    ListAdapter<MainType, RecyclerView.ViewHolder>(MainCallBack()) {

    var listAlbumAdapter: ListAlbumAdapter = ListAlbumAdapter(onItemHome, -1)
    var listBannerAdapter: ListBannerAdapter = ListBannerAdapter(onItemHome, -1)

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ListBannerType -> {
                ARRAY_BANNER
            }
            is ListAlbumType -> {
                ARRAY_ALBUM
            }
            is SongType -> {
                SONG
            }
            is FieldTitleType -> {
                TEXT
            }
        }
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
                return ItemSongViewHolder(itemSong, onItemHome)
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
        when (getItemViewType(position)) {
            TEXT -> {
                val textViewHolder = holder as ItemTextViewHolder
                textViewHolder.textView.text = (getItem(position) as FieldTitleType).title
            }
            SONG -> {
                val songViewHolder = holder as ItemSongViewHolder
                val song = (getItem(position) as SongType).song
                songViewHolder.imageSong.setImageResource(song.image)
                songViewHolder.textSongName.text = song.name
            }
            ARRAY_BANNER -> {
                val bannerViewHolder = holder as ListBannerViewHolder
                bannerViewHolder.recyclerView.adapter = listBannerAdapter
            }
            ARRAY_ALBUM -> {
                val albumViewHolder = holder as ListAlbumViewHolder
                albumViewHolder.recyclerView.adapter = listAlbumAdapter
            }

        }
    }

    companion object {
        private const val ARRAY_BANNER = 0
        private const val ARRAY_ALBUM = 1
        private const val SONG = 2
        private const val TEXT = 3
    }
}