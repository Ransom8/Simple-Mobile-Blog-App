package com.example.week11_architecture.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week11_architecture.R
import com.example.week11_architecture.adapter.MyAdapter
import com.example.week11_architecture.adapter.OnClick
import com.example.week11_architecture.model.Post
import com.example.week11_architecture.models.MainViewModel
import com.example.week11_architecture.models.ViewModelFactory
import com.example.week11_architecture.repository.Repository
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_posts.*

/**
 * This is the activity class for the post activity
 */

class PostsFragment : Fragment(R.layout.fragment_posts), View.OnClickListener, OnClick {

    lateinit var navController: NavController
    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<FloatingActionButton>(R.id.addPostFAB).setOnClickListener(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        /**
         * This is where the view model for the post is applied, and the recycler view and recycler
         * view data is inflated into the activity
         */

        val repository = Repository()
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                recyclerView.adapter = MyAdapter(response.body()!!, this)
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
            } else {
                Toast.makeText(requireContext(), "Hmmmm...That's odd", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.addPostFAB -> navController.navigate(R.id.action_postsFragment_to_addPostFragment)
        }
    }

    /**
     * This is the post click class that handles the click for each post.
     */

    override fun onItemClick(item: Post, position: Int) {
        navController = Navigation.findNavController(requireView())
        val action =
            PostsFragmentDirections.actionPostsFragmentToCommentsFragment(item.id, item.title)
        navController.navigate(action)
        Toast.makeText(requireContext(), "Comment clicked", Toast.LENGTH_SHORT).show()
    }

}