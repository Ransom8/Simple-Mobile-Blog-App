package com.example.week11_architecture.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.week11_architecture.repository.Repository

/**
 * This view model factory for the posts view model
 */

//class ViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return modelClass.getConstructor().newInstance(repository) as T
//    }
//}
class ViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}