package com.example.recyclerview.utils

import com.example.recyclerview.R
import com.example.recyclerview.model.Album
import com.example.recyclerview.model.Banner
import com.example.recyclerview.model.Song

class DataUtil {
    companion object {
        fun getMainList(): ArrayList<MainType> {
            val banners = Banner.getBanners()
            val albums = Album.getAlbums()
            return arrayListOf(
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
    }

}