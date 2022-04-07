package com.example.recyclerview.model

import com.example.recyclerview.R

class Album (val image: Int, val name: String) {
    companion object {
        fun getAlbums(): ArrayList<Album> {
            return arrayListOf(
                Album(R.drawable.album, "Album 1"),
                Album(R.drawable.album, "Album 2"),
                Album(R.drawable.album, "Album 3"),
                Album(R.drawable.album, "Album 4"),
                Album(R.drawable.album, "Album 5"),
                Album(R.drawable.album, "Album 6"),
                Album(R.drawable.album, "Album 7"),
                Album(R.drawable.album, "Album 8"),
                Album(R.drawable.album, "Album 9"),
                Album(R.drawable.album, "Album 10"),
                Album(R.drawable.album, "Album 11"),
                Album(R.drawable.album, "Album 12"),
                Album(R.drawable.album, "Album 13"),
                Album(R.drawable.album, "Album 14"),
                Album(R.drawable.album, "Album 15"),
            )
        }
    }
}