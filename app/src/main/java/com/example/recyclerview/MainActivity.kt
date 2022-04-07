package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.adapters.MainAdapter
import com.example.recyclerview.model.Song
import com.example.recyclerview.utils.DataUtil
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.main_recycler_view)

        val mainList = DataUtil.getMainList()
        val mainAdapter = MainAdapter(mainList)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = mainAdapter

    }
}