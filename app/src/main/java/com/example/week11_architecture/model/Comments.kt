package com.example.week11_architecture.model

/**
 * The comment data class that collects the values from the comments Json in the API
 */

data class Comments(
    val postId: Int,
    val name: String,
    val id: Int,
    val email: String,
    val body: String
)