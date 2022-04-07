package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.adapters.MainAdapter
import com.example.recyclerview.model.Album
import com.example.recyclerview.model.Banner
import com.example.recyclerview.model.Song
import com.example.recyclerview.utils.DataUtil


class MainActivity : AppCompatActivity(), Toaster {
    lateinit var recyclerView: RecyclerView
    lateinit var mainList: ArrayList<Any>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.main_recycler_view)

        mainList = DataUtil.getMainList()
        val mainAdapter = MainAdapter(mainList, this)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = mainAdapter
    }

    override fun showToast(position: Int, childPosition: Int?) {
        val message: String
        var content = ""
        if (childPosition == null) {
            if (mainList[position] is Song) {
                content = "Song: ${(mainList[position] as Song).name}"
            }
        } else { // childPosition != null -> ArrayList
            val arrayList = mainList[position] as ArrayList<*>
            if (arrayList.firstOrNull() is Banner) {
                content = "Banner pos: $childPosition"
            } else if (arrayList.firstOrNull() is Album) {
                content = "Album: ${(arrayList[childPosition] as Album).name}"
            }
        }
        message = "pos: $position , $content"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}