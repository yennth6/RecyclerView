package com.example.recyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.model.Banner

class ListBannerAdapter(val listener: OnItemHomeClickListener, var parentPosition: Int) :
    ListAdapter<Banner, ListBannerAdapter.ViewHolder>(BannerCallback()) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bannerImage: ImageView = view.findViewById(R.id.image_banner)
        private val textDelete: TextView = view.findViewById(R.id.text_delete_banner)

        init {
            textDelete.setOnClickListener {
                listener.onClickDeleteItem(parentPosition, adapterPosition)
            }
            itemView.setOnClickListener {
                listener.onClickItem(parentPosition, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_banner, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val banner = getItem(position)
        holder.bannerImage.setImageResource(banner.image)
    }
}