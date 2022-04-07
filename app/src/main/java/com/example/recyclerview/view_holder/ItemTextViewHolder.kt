package com.example.recyclerview.view_holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R

class ItemTextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val textView: TextView = view.findViewById(R.id.text_field_title)
}
