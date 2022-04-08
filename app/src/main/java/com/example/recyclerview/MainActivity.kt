package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.adapters.MainAdapter
import com.example.recyclerview.data.MainRepository
import com.example.recyclerview.data.MainViewModel
import com.example.recyclerview.data.MainViewModelFactory
import com.example.recyclerview.utils.*


class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    private lateinit var mainList: ArrayList<MainType>
    private val repository: MainRepository = MainRepository()
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory(repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.main_recycler_view)
//        mainList = DataUtil.getMainList()
        mainList = mainViewModel.data.value!!

        val mainAdapter = MainAdapter(mainViewModel, object : Toaster {
            override fun showToast(position: Int, childPosition: Int?) {
                myShowToast(position, childPosition)
            }
        })


        recyclerView.adapter = mainAdapter
        mainViewModel.data.observe(this) {
            Log.d("MainActivity", "Update")
            Log.d("MainActivity", it.size.toString())
            mainAdapter.submitList(it.toMutableList())
        }
    }

     fun myShowToast(position: Int, childPosition: Int?) {
         val message: String
         var content = ""
        val mainList = mainViewModel.data.value!!
         when(mainList[position]) {
             is SongType -> {
                 content = "Song: ${(mainList[position] as SongType).song.name}"
             }

             is ListBannerType -> {
                 childPosition?. let { content = "Banner pos: $childPosition" }
             }

             is ListAlbumType -> {
                 childPosition?.let {
                     val album = ((mainList[position] as ListAlbumType).albums)[childPosition]
                     content = "Album: ${album.name}"
                 }
             }

             else -> {

             }
         }

         message = "pos: $position , $content"
         Log.d("MainActivity", "showToast message $message")

         Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}