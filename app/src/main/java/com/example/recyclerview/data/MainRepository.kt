package com.example.recyclerview.data

import com.example.recyclerview.data.api.ApiHelper
import com.example.recyclerview.data.model.*

class MainRepository(private val apiHelper: ApiHelper) {

    private fun toSongType(songs: List<Song>?): ArrayList<SongType> {
        val res = arrayListOf<SongType>()
        if (songs != null) {
            for (song in songs) {
                res.add(SongType(song))
            }
        }
        return res
    }

    suspend fun getTopSongs() = toSongType(apiHelper.getTopSongs().body())

    suspend fun getAllSongs() = toSongType(apiHelper.getAllSongs().body())

    suspend fun getAlbums(url: String) = apiHelper.getAlbums(url).body()
}