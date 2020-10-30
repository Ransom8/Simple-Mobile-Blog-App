package com.example.week11_architecture.api

import com.example.week11_architecture.constant.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * This object is the retrofit that makes the network call from the API URL
 */

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: SampleApi by lazy {
        retrofit.create(SampleApi::class.java)
    }
}