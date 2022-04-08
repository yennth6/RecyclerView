package com.example.recyclerview.adapters

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerview.utils.ListAlbumType
import com.example.recyclerview.utils.ListBannerType
import com.example.recyclerview.utils.MainType
import com.example.recyclerview.utils.SongType

class CallBack: DiffUtil.ItemCallback<MainType>() {
    override fun areItemsTheSame(oldItem: MainType, newItem: MainType): Boolean {
        if (
            (oldItem is ListBannerType && newItem is ListBannerType)
        ) {
            if ((oldItem).banners.size != (newItem).banners.size) {
                return false
            }
            for (i in 0 until oldItem.banners.size) {
                if (oldItem.banners[i] != newItem.banners[i]) {
                    return false
                }
            }
            Log.d("CallBack", "true in Banners")
            return true
        } else if ( oldItem is ListAlbumType && newItem is ListAlbumType){
            if ((oldItem).albums.size != (newItem).albums.size) {
                return false
            }
            for (i in 0 until oldItem.albums.size) {
                if (oldItem.albums[i] != newItem.albums[i]) {
                    return false
                }
            }
            Log.d("CallBack", "true in Albums")

            return true
        } else {
            return true
        }
    }

    override fun areContentsTheSame(oldItem: MainType, newItem: MainType): Boolean {
//        if (oldItem is ListBannerType && newItem is ListBannerType) {
//            return true
//        }
//        if (oldItem is ListAlbumType && newItem is ListAlbumType) {
//            return true
//        }
        if (oldItem is SongType && newItem is SongType) {
            return oldItem.song == newItem.song
        }
        return false
    }

}
