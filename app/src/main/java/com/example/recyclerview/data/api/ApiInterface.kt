package com.example.recyclerview.data.api

import com.example.recyclerview.data.model.Album
import com.example.recyclerview.data.model.Song
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiInterface {
    @GET("api/v1/songs")
    suspend fun getAllSongs() : Response<List<Song>>

    @GET("api/v1/top")
    suspend fun getTopSongs() : Response<List<Song>>

    @GET
    suspend fun getAlbums(@Url url: String) : Response<List<Album>>
}