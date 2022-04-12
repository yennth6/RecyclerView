package com.example.recyclerview.data

import android.util.Log
import com.example.recyclerview.R
import com.example.recyclerview.model.Album
import com.example.recyclerview.model.Banner
import com.example.recyclerview.model.Song
import com.example.recyclerview.utils.*

class MainRepository {
    private var dataList = ArrayList<MainType>()
    init {
        val banners = Banner.getBanners()
        val albums = Album.getAlbums()
        dataList = arrayListOf(
            ListBannerType(banners),
            FieldTitleType("New Songs"),
            SongType(Song(R.drawable.new_song, "Bai 1")),
            SongType(Song(R.drawable.new_song, "Bai 2")),
            SongType(Song(R.drawable.new_song, "Bai 3")),
            SongType(Song(R.drawable.new_song, "Bai 4")),
            SongType(Song(R.drawable.new_song, "Bai 5")),
            SongType(Song(R.drawable.new_song, "Bai 6")),
            SongType(Song(R.drawable.new_song, "Bai 7")),
            SongType(Song(R.drawable.new_song, "Bai 8")),
            SongType(Song(R.drawable.new_song, "Bai 9")),
            SongType(Song(R.drawable.new_song, "Bai 10")),
            SongType(Song(R.drawable.new_song, "Bai 11")),
            SongType(Song(R.drawable.new_song, "Bai 12")),
            SongType(Song(R.drawable.new_song, "Bai 13")),
            SongType(Song(R.drawable.new_song, "Bai 14")),
            SongType(Song(R.drawable.new_song, "Bai 15")),
            SongType(Song(R.drawable.new_song, "Bai 16")),
            SongType(Song(R.drawable.new_song, "Bai 17")),
            SongType(Song(R.drawable.new_song, "Bai 18")),
            FieldTitleType("Favorite Songs"),
            SongType(Song(R.drawable.fav_song, "Bai 1")),
            SongType(Song(R.drawable.fav_song, "Bai 2")),
            SongType(Song(R.drawable.fav_song, "Bai 3")),
            SongType(Song(R.drawable.fav_song, "Bai 4")),
            SongType(Song(R.drawable.fav_song, "Bai 5")),
            SongType(Song(R.drawable.fav_song, "Bai 6")),
            SongType(Song(R.drawable.fav_song, "Bai 7")),
            SongType(Song(R.drawable.fav_song, "Bai 8")),
            SongType(Song(R.drawable.fav_song, "Bai 9")),
            SongType(Song(R.drawable.fav_song, "Bai 10")),
            SongType(Song(R.drawable.fav_song, "Bai 11")),
            SongType(Song(R.drawable.fav_song, "Bai 12")),
            SongType(Song(R.drawable.fav_song, "Bai 13")),
            SongType(Song(R.drawable.fav_song, "Bai 14")),
            SongType(Song(R.drawable.fav_song, "Bai 15")),
            SongType(Song(R.drawable.fav_song, "Bai 16")),
            SongType(Song(R.drawable.fav_song, "Bai 17")),
            SongType(Song(R.drawable.fav_song, "Bai 18")),
            FieldTitleType("Albums"),
            ListAlbumType(albums)
        )
    }
    fun getListPosition(): Pair<Int, Int> {
        var listBannerPos = -1
        var listAlbumPos = -1
        for (i in 0 until dataList.size) {
            if (dataList[i] is ListBannerType) {
                listBannerPos = i
            }
            if (dataList[i] is ListAlbumType) {
                listAlbumPos = i
            }
        }
        return Pair(listBannerPos, listAlbumPos)
    }
    fun getData(): ArrayList<MainType> {
        return dataList
    }
    fun deleteItem(position: Int, childPosition: Int): ArrayList<MainType> {
        Log.d("MainRepository", "Del")
        if (childPosition == -1) {
            dataList.removeAt(position)
        } else {
            when (val list = dataList[position]) {
                is ListAlbumType -> {
                    list.albums.removeAt(childPosition)
                }
                is ListBannerType -> {
                    list.banners.removeAt(childPosition)
                }
                else -> {
                    Log.d("MainRepository", "else")
                }
            }

        }
        return dataList
    }
}