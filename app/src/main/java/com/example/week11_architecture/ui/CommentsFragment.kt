package com.example.week11_architecture.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week11_architecture.R
import com.example.week11_architecture.adapter.CommentsAdapter
import com.example.week11_architecture.models.CommentsViewModel
import com.example.week11_architecture.models.CommentsViewModelFactory
import com.example.week11_architecture.repository.Repository
import kotlinx.android.synthetic.main.fragment_comments.*

/**
 * This is the activity class for the comments activity
 */

class CommentsFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    private lateinit var viewModel: CommentsViewModel
    private lateinit var commentsAdapter: CommentsAdapter
    var commentId: Int = 0
    lateinit var title: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = Navigation.findNavController(view)
        addCommentFAB.setOnClickListener(this)
        imageButton.setOnClickListener(this)

        val bundle = CommentsFragmentArgs.fromBundle(requireArguments())
        title = bundle.postName
        textViewComments.text = title
        commentId = bundle.id

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        /**
         * This is where the view model for the comments is applied, and the recycler view and recycler
         * view data is inflated into the activity
         */

        val repository = Repository()
        val viewModelFactory = CommentsViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CommentsViewModel::class.java)
        viewModel.getPostComments(commentId)
        viewModel.commentsResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                commentsAdapter = CommentsAdapter(response.body()!!)
                recyclerViewComments.adapter = commentsAdapter
                recyclerViewComments.layoutManager = LinearLayoutManager(requireContext())
            } else {
                Toast.makeText(requireContext(), "Hmmmm...That's odd", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comments, container, false)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.addCommentFAB -> {
                navController = Navigation.findNavController(requireView())
                val action = bundleOf("postName" to title, "id" to commentId)
                navController.navigate(R.id.action_commentsFragment_to_addCommentFragment, action)
            }
            R.id.imageButton -> navController.navigate(R.id.action_commentsFragment_to_postsFragment)
        }
    }

}