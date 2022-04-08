package com.example.recyclerview.utils

import com.example.recyclerview.model.Album
import com.example.recyclerview.model.Banner
import com.example.recyclerview.model.Song

sealed class MainType
class SongType(val song: Song) : MainType()
class FieldTitleType(val title: String) : MainType()
class ListBannerType(val banners: ArrayList<Banner>) : MainType()
class ListAlbumType(val albums: ArrayList<Album>) : MainType()