package com.example.recyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.Toaster
import com.example.recyclerview.model.Banner

class ListBannerAdapter(private val bannerList: ArrayList<*>,
                        private val toaster: Toaster,
                        private val parentPosition: Int) :
    RecyclerView.Adapter<ListBannerAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bannerImage: ImageView = view.findViewById(R.id.image_banner)
        val textDelete: TextView = view.findViewById(R.id.text_delete_banner)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_banner, parent, false)
        val holder =  ViewHolder(view)
        holder.textDelete.setOnClickListener {
            bannerList.removeAt(holder.adapterPosition)
            this.notifyItemRemoved(holder.adapterPosition)
        }
        holder.itemView.setOnClickListener {
            toaster.showToast(parentPosition, holder.adapterPosition)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val banner = bannerList[position] as Banner
        holder.bannerImage.setImageResource(banner.image)
    }

    override fun getItemCount(): Int {
        return bannerList.size
    }
}