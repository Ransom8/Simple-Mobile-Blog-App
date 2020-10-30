package com.example.week11_architecture.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week11_architecture.model.Post
import com.example.week11_architecture.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

/**
 * This is the view model that does the network call for the posts. It uses coroutine and gets the
 * data as an array into the view created for the purpose.
 */

class MainViewModel(private val repository: Repository): ViewModel() {

    var myResponse: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }

//    fun getSearchPost(search:String): MutableLiveData<Response<List<Post>>> {
//        return myResponse
//    }
}