package com.example.recyclerview.data.model

sealed class MainType
class SongType(val song: Song) : MainType()
class FieldTitleType(val title: String) : MainType()
class ListBannerType(val banners: ArrayList<Banner>) : MainType()
class ListAlbumType(val albums: ArrayList<Album>) : MainType()