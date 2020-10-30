package com.example.week11_architecture.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.week11_architecture.repository.Repository

/**
 * This view model factory for the comments view model
 */

class CommentsViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CommentsViewModel(repository) as T
    }
}