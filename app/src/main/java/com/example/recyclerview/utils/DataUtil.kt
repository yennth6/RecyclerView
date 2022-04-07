package com.example.recyclerview.utils

import com.example.recyclerview.R
import com.example.recyclerview.model.Album
import com.example.recyclerview.model.Banner
import com.example.recyclerview.model.Song

class DataUtil {
    companion object {
        fun getMainList(): ArrayList<Any> {
            val banners = Banner.getBanners()
            val albums = Album.getAlbums()
            return arrayListOf(
                banners,
                "New Songs",
                Song(R.drawable.new_song, "Bai 1"),
                Song(R.drawable.new_song, "Bai 2"),
                Song(R.drawable.new_song, "Bai 3"),
                Song(R.drawable.new_song, "Bai 4"),
                Song(R.drawable.new_song, "Bai 5"),
                Song(R.drawable.new_song, "Bai 6"),
                Song(R.drawable.new_song, "Bai 7"),
                Song(R.drawable.new_song, "Bai 8"),
                Song(R.drawable.new_song, "Bai 9"),
                Song(R.drawable.new_song, "Bai 10"),
                Song(R.drawable.new_song, "Bai 11"),
                Song(R.drawable.new_song, "Bai 12"),
                Song(R.drawable.new_song, "Bai 13"),
                Song(R.drawable.new_song, "Bai 14"),
                Song(R.drawable.new_song, "Bai 15"),
                Song(R.drawable.new_song, "Bai 16"),
                Song(R.drawable.new_song, "Bai 17"),
                Song(R.drawable.new_song, "Bai 18"),
                "Favorite Songs",
                Song(R.drawable.fav_song, "Bai 1"),
                Song(R.drawable.fav_song, "Bai 2"),
                Song(R.drawable.fav_song, "Bai 3"),
                Song(R.drawable.fav_song, "Bai 4"),
                Song(R.drawable.fav_song, "Bai 5"),
                Song(R.drawable.fav_song, "Bai 6"),
                Song(R.drawable.fav_song, "Bai 7"),
                Song(R.drawable.fav_song, "Bai 8"),
                Song(R.drawable.fav_song, "Bai 9"),
                Song(R.drawable.fav_song, "Bai 10"),
                Song(R.drawable.fav_song, "Bai 11"),
                Song(R.drawable.fav_song, "Bai 12"),
                Song(R.drawable.fav_song, "Bai 13"),
                Song(R.drawable.fav_song, "Bai 14"),
                Song(R.drawable.fav_song, "Bai 15"),
                Song(R.drawable.fav_song, "Bai 16"),
                Song(R.drawable.fav_song, "Bai 17"),
                Song(R.drawable.fav_song, "Bai 18"),
                "Albums",
                albums
            )
        }
    }

}