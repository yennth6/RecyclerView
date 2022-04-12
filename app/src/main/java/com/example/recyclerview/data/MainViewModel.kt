package com.example.recyclerview.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerview.utils.MainType

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {
    private val rawData = repository.getData()
    private val dataList = MutableLiveData(rawData)

    val data: LiveData<ArrayList<MainType>> get() = dataList
    val listPositions: LiveData<Pair<Int, Int>> get() = MutableLiveData(repository.getListPosition())
    fun deleteItem(position: Int, childPosition: Int) {
            dataList.value = repository.deleteItem(position, childPosition)
    }
}