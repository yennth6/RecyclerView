package com.example.recyclerview.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerview.data.model.*

class MainCallBack : DiffUtil.ItemCallback<MainType>() {
    override fun areItemsTheSame(oldItem: MainType, newItem: MainType): Boolean {
        if (oldItem is ListBannerType && newItem is ListBannerType) {
            return true
        }
        if (oldItem is ListAlbumType && newItem is ListAlbumType) {
            return true
        }
        if (oldItem is SongType && newItem is SongType) {
            return oldItem.song.id == newItem.song.id
        }

        if (oldItem is FieldTitleType && newItem is FieldTitleType) {
            return oldItem.title == newItem.title
        }
        return false
    }

    override fun areContentsTheSame(oldItem: MainType, newItem: MainType): Boolean {
        if (oldItem is ListBannerType && newItem is ListBannerType) {
            return false
        }

        if (oldItem is ListAlbumType && newItem is ListAlbumType) {
            return false
        }

        if (oldItem is SongType && newItem is SongType) {
            return oldItem.song == newItem.song
        }

        if (oldItem is FieldTitleType && newItem is FieldTitleType) {
            return oldItem.title == newItem.title
        }

        return false
    }

    override fun getChangePayload(oldItem: MainType, newItem: MainType): Any? {
        return if ((oldItem is ListBannerType && newItem is ListBannerType)
            || (oldItem is ListAlbumType && newItem is ListAlbumType)
        ) {
            true
        } else {
            null
        }
    }
}
