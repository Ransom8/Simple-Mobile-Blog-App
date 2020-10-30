package com.example.week11_architecture.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week11_architecture.model.Comments
import com.example.week11_architecture.model.Post
import com.example.week11_architecture.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

/**
 * This is the view model that does the network call. It uses coroutine and gets the data as an array
 * into the view created for the purpose
 */

class CommentsViewModel(private val repository: Repository): ViewModel() {

    var myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    var commentsResponse: MutableLiveData<Response<List<Comments>>> = MutableLiveData()

    fun getPostComments(id: Int) {
        viewModelScope.launch {
            val response = repository.getPostComments(id)
            commentsResponse.value = response
        }
    }

    fun pushPost(post: Post) {
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }
}