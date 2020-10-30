package com.example.week11_architecture.api

import com.example.week11_architecture.model.Comments
import com.example.week11_architecture.model.Post
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * This interface holds and handles the API requests
 */

interface SampleApi {

    @GET("posts")
    suspend fun getPost(): Response<List<Post>>

    @GET("posts/{id}/comments")
    suspend fun getPostComments(@Path("id")id: Int): Response<List<Comments>>

//    @POST("posts/{id}/comments")
//    suspend fun pushComments(
//        @Body comment: Comments
//    ): Response<List<Comments>>

    @POST("posts")
    suspend fun pushPost(
        @Body post: Post
    ): Response<Post>

}