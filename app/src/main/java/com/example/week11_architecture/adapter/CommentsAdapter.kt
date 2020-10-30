package com.example.week11_architecture.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week11_architecture.R
import com.example.week11_architecture.model.Comments
import kotlinx.android.synthetic.main.recycler_comments.view.*

/**
 * This is the adapter class that handle the recycler view for the calling the comments from
 * Database
 */

class CommentsAdapter(var commentsList: List<Comments>) :
    RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>() {

    inner class CommentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        return CommentsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_comments, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        holder.itemView.comment_body.text = commentsList[position].body
        holder.itemView.comment_name.text = commentsList[position].name
        holder.itemView.comment_email.text = commentsList[position].email
    }

    override fun getItemCount(): Int {
        return commentsList.size
    }

    /**
     * This function sets the data for the comments into the recycler view on the comments
     * list
     */

    fun setData(newList: List<Comments>){
        commentsList = newList
        notifyDataSetChanged()
    }
}