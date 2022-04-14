package com.example.recyclerview.data

import android.util.Log
import androidx.lifecycle.*
import com.example.recyclerview.data.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {
    val data = MutableLiveData<ArrayList<MainType>?>()

    init {
        getDataList()
    }

    private fun getDataList() = viewModelScope.launch(Dispatchers.IO) {
        val allSongs = async { repository.getAllSongs() }
        val topSongs = async { repository.getTopSongs() }
        val albums = async {
            repository.getAlbums("https://6215b273c9c6ebd3ce2f03ca.mockapi.io/albums")
        }

        val result = listOf(allSongs, topSongs, albums).awaitAll()

        val allSongsResponse = result[0] as List<*>
        val topSongsResponse = result[1] as List<*>
        val albumsResponse = result[2] as List<*>

        val banners = Banner.getBanners()

        data.postValue(parseData(topSongsResponse, allSongsResponse, albumsResponse, banners))
    }

    private fun parseData(topSongs: List<*>,
                          allSongs: List<*>,
                          albums: List<*>,
                          banners: ArrayList<Banner>): ArrayList<MainType> {
        val dataList = ArrayList<MainType>()
        dataList.add(ListBannerType(banners))
        dataList.add(FieldTitleType("Top Songs"))
        for (i in topSongs) {
            dataList.add(i as SongType)
        }

        dataList.add(FieldTitleType("All Songs"))
        for (i in allSongs) {
            dataList.add(i as SongType)
        }
        dataList.add(FieldTitleType("Albums"))

        val albumsList = ArrayList<Album>()
        for (i in albums) {
            albumsList.add(i as Album)
        }
        dataList.add(ListAlbumType(albumsList))

        return dataList
    }


    fun deleteItem(position: Int, childPosition: Int) {
        val dataList = data.value
        if (childPosition == -1) {
            dataList?.removeAt(position)
        } else {
            when (val list = dataList?.get(position)) {
                is ListAlbumType -> {
                    list.albums.removeAt(childPosition)
                }
                is ListBannerType -> {
                    list.banners.removeAt(childPosition)
                }
                else -> {
                    Log.d(TAG, "else")
                }
            }
        }
        data.postValue(dataList)
    }

    companion object {
        private const val TAG = "MainViewModel"
    }
}