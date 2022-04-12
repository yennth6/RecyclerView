package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.adapters.MainAdapter
import com.example.recyclerview.adapters.OnItemHomeClickListener
import com.example.recyclerview.data.MainRepository
import com.example.recyclerview.data.MainViewModel
import com.example.recyclerview.data.MainViewModelFactory
import com.example.recyclerview.utils.*


class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
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

        val mainAdapter = MainAdapter(object  : OnItemHomeClickListener {
            override fun onClickItem(parentPosition: Int, childPosition: Int) {
                showToast(parentPosition, childPosition)
            }

            override fun onClickDeleteItem(parentPosition: Int, childPosition: Int) {
                mainViewModel.deleteItem(parentPosition, childPosition)
            }

        })


        recyclerView.adapter = mainAdapter
        mainViewModel.data.observe(this) {
            val (bannersPos, albumsPos) = mainViewModel.listPositions.value!!
            val banners = ArrayList((it[bannersPos] as ListBannerType).banners)
            val albums = ArrayList((it[albumsPos] as ListAlbumType).albums)

            mainAdapter.submitList(it.toMutableList())
            mainAdapter.listBannerAdapter.submitList(banners)
            mainAdapter.listAlbumAdapter.submitList(albums)

            mainAdapter.listBannerAdapter.parentPosition = bannersPos
            mainAdapter.listAlbumAdapter.parentPosition = albumsPos
        }
    }

     fun showToast(position: Int, childPosition: Int) {
         val message: String
         var content = ""
         val mainList = mainViewModel.data.value!!
         when(mainList[position]) {
             is SongType -> {
                 content = "Song: ${(mainList[position] as SongType).song.name}"
             }

             is ListBannerType -> {
                 content = "Banner pos: $childPosition"
             }

             is ListAlbumType -> {
                 val album = ((mainList[position] as ListAlbumType).albums)[childPosition]
                 content = "Album: ${album.name}"
             }

             else -> {

             }
         }

         message = "pos: $position , $content"
         Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}