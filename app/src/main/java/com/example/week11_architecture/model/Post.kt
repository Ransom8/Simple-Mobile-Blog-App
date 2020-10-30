package com.example.week11_architecture.model

/**
 * The post data class that collects the values from the post Json in the API
 */

data class Post(
    val body: String,
    val userId: Int,
    val title: String,
    val id: Int
)