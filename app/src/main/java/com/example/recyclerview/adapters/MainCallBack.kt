package com.example.recyclerview.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerview.utils.*

class MainCallBack: DiffUtil.ItemCallback<MainType>() {
    override fun areItemsTheSame(oldItem: MainType, newItem: MainType): Boolean {
        if (oldItem is ListBannerType && newItem is ListBannerType) {
            return true
        }
        if ( oldItem is ListAlbumType && newItem is ListAlbumType){
            return true
        }
        if (oldItem is SongType && newItem is SongType) {
            return oldItem.song.name == newItem.song.name
        }

        if (oldItem is FieldTitleType && newItem is FieldTitleType) {
            return oldItem.title == newItem.title
        }
        return false
    }

    override fun areContentsTheSame(oldItem: MainType, newItem: MainType): Boolean {
        if (oldItem is ListBannerType && newItem is ListBannerType) {
            if ((oldItem).banners.size != (newItem).banners.size) {
                return false
            }
            for (i in 0 until oldItem.banners.size) {
                if (oldItem.banners[i].name != newItem.banners[i].name) {
                    return false
                }
                if (newItem.banners[i].name != oldItem.banners[i].name
                        && newItem.banners[i].image != oldItem.banners[i].image) {
                    return false
                }
            }
            return true
        }

        if (oldItem is ListAlbumType && newItem is ListAlbumType) {
            if ((oldItem).albums.size != (newItem).albums.size) {
                return false
            }
            for (i in 0 until oldItem.albums.size) {
                if (oldItem.albums[i].name != newItem.albums[i].name) {
                    return false
                }
                if (newItem.albums[i].name != oldItem.albums[i].name
                        && newItem.albums[i].image != oldItem.albums[i].image) {
                    return false
                }

            }
            return true
        }

        if (oldItem is SongType && newItem is SongType) {
            return oldItem.song == newItem.song
        }

        if (oldItem is FieldTitleType && newItem is FieldTitleType) {
            return oldItem.title == newItem.title
        }

        return false
    }

}
