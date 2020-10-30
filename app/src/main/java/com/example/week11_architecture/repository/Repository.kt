package com.example.week11_architecture.repository

import com.example.week11_architecture.api.RetrofitInstance
import com.example.week11_architecture.model.Comments
import com.example.week11_architecture.model.Post
import retrofit2.Response

class Repository {

    /**
     * The get post function that collects the posts from the API
     */

    suspend fun getPost(): Response<List<Post>> {
        return RetrofitInstance.api.getPost()
    }

    /**
     * The get post comments function that collects the comments from the API
     */

    suspend fun getPostComments(id: Int): Response<List<Comments>> {
        return RetrofitInstance.api.getPostComments(id)
    }

//    suspend fun pushComment(comment: Comments): Response<List<Comments>> {
//        return RetrofitInstance.api.pushComments(comment)
//    }

    suspend fun pushPost(post: Post): Response<Post> {
        return RetrofitInstance.api.pushPost(post)
    }

}