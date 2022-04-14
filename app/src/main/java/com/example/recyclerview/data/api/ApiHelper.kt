package com.example.recyclerview.data.api

class ApiHelper (private val api: ApiInterface) {
    suspend fun getAllSongs() = api.getAllSongs()
    suspend fun getTopSongs() = api.getTopSongs()
    suspend fun getAlbums(url: String) = api.getAlbums(url)
}