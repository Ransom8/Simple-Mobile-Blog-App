package com.example.week11_architecture.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.week11_architecture.R
import kotlinx.android.synthetic.main.fragment_add_post.*

class AddPostFragment : Fragment(R.layout.fragment_add_post), View.OnClickListener {

    lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = Navigation.findNavController(requireView())
        addPost.setOnClickListener(this)
        imageButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.addPost, R.id.imageButton -> navController.navigate(R.id.action_addPostFragment_to_postsFragment)
        }
    }
}