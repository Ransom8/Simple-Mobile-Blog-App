package com.example.week11_architecture.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week11_architecture.R
import com.example.week11_architecture.model.Post
import kotlinx.android.synthetic.main.recycler.view.*

/**
 * This recycler view adapter class handles the recycler view for the posts from API
 */

class MyAdapter(var posts: List<Post>, var listener: OnClick) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val singlePost: TextView = itemView.body
        val postTitle: TextView = itemView.title

        /**
         * This initialise function takes the onClick function and handles click for each view
         * in the recycler view
         */

        fun initialise(item: Post, action: OnClick) {
            singlePost.text = item.body
            postTitle.text = item.title

            itemView.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }
            singlePost.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }

            postTitle.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.initialise(posts[position], listener)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

}