package com.example.recyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.Toaster
import com.example.recyclerview.data.MainViewModel
import com.example.recyclerview.utils.*
import com.example.recyclerview.view_holder.ItemSongViewHolder
import com.example.recyclerview.view_holder.ItemTextViewHolder
import com.example.recyclerview.view_holder.ListAlbumViewHolder
import com.example.recyclerview.view_holder.ListBannerViewHolder

class MainAdapter(private val viewModel: MainViewModel, private val toaster: Toaster) :
    ListAdapter<MainType, RecyclerView.ViewHolder>(CallBack()) {
    private var albumAdapter: ListAlbumAdapter? = null
    private val mainList = viewModel.data.value !!
    override fun getItemViewType(position: Int): Int {
        return when (mainList[position]) {
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
                return ItemSongViewHolder(itemSong, toaster, viewModel)
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
                textViewHolder.textView.text = (mainList[position] as FieldTitleType).title
            }
            SONG -> {
                val songViewHolder = holder as ItemSongViewHolder
                val song = (mainList[position] as SongType).song
                songViewHolder.imageSong.setImageResource(song.image)
                songViewHolder.textSongName.text = song.name
            }
            ARRAY_BANNER -> {
                val bannerViewHolder = holder as ListBannerViewHolder
                val bannerList =( mainList[position] as ListBannerType).banners
                val adapter = ListBannerAdapter(bannerList, toaster,
                    bannerViewHolder.adapterPosition, viewModel)
                bannerViewHolder.recyclerView.adapter = adapter
            }
            ARRAY_ALBUM -> {
                val albumViewHolder = holder as ListAlbumViewHolder
                val albumList = (mainList[position] as ListAlbumType).albums

                albumAdapter = ListAlbumAdapter(albumList, toaster,
                    albumViewHolder.adapterPosition, viewModel)
                albumViewHolder.recyclerView.adapter = albumAdapter
            }

        }
    }

//    override fun onBindViewHolder(
//        holder: RecyclerView.ViewHolder,
//        position: Int,
//        payloads: MutableList<Any>
//    ) {
//        if (payloads.isNotEmpty()) {
//            if (payloads[0] is Boolean) {
//                albumAdapter?.parentPosition = albumAdapter?.parentPosition?.minus(1)!!
//            }
//        }
//        else {
//            super.onBindViewHolder(holder, position, payloads)
//        }
//    }

    override fun getItemCount(): Int {
        return mainList.size
    }

    fun getListItems(): ArrayList<MainType> {
        return mainList
    }

    companion object {
        private  const val ARRAY_BANNER = 0
        private const val ARRAY_ALBUM = 1
        private const val SONG = 2
        private const val TEXT = 3
    }
}