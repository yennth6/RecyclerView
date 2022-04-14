package com.example.recyclerview.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerview.data.model.Banner

class BannerCallback : DiffUtil.ItemCallback<Banner>() {
    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem.name == newItem.name && oldItem.image == newItem.image
    }
}