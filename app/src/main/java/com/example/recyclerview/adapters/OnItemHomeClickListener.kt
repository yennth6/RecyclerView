package com.example.recyclerview.adapters

interface OnItemHomeClickListener {
    fun onClickItem(parentPosition: Int, childPosition: Int)

    fun onClickDeleteItem(parentPosition: Int, childPosition: Int)
}