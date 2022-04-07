package com.example.recyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.model.Banner

class ListBannerAdapter(private val bannerList: ArrayList<*>) :
    RecyclerView.Adapter<ListBannerAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bannerImage: ImageView = view.findViewById(R.id.image_banner)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_banner, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val banner = bannerList[position] as Banner
        holder.bannerImage.setImageResource(banner.image)
    }

    override fun getItemCount(): Int {
        return bannerList.size
    }
}