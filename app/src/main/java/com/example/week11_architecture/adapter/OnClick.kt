package com.example.week11_architecture.adapter

import com.example.week11_architecture.model.Post

/**
 * This OnClick interface is used to handle the recycler view click
 */

interface OnClick {

    fun onItemClick(item: Post, position: Int) {

    }
}