package com.example.week11_architecture.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.week11_architecture.R
import com.example.week11_architecture.adapter.OnClick
import com.example.week11_architecture.model.Post
import kotlinx.android.synthetic.main.fragment_add_comment.*
import kotlin.properties.Delegates


class AddCommentFragment : Fragment(), View.OnClickListener, OnClick {

    lateinit var navController: NavController
    var commentId by Delegates.notNull<Int>()
    var title by Delegates.notNull<String>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = Navigation.findNavController(view)
        addComment.setOnClickListener(this)
        imageButton.setOnClickListener(this)

        val bundle = CommentsFragmentArgs.fromBundle(requireArguments())
        title = bundle.postName
        commentId = bundle.id
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_comment, container, false)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.addComment -> {
                navController = Navigation.findNavController(requireView())
                val action = bundleOf("postName" to title, "id" to commentId)
                navController.navigate(R.id.action_addCommentFragment_to_commentsFragment, action)
            }
            R.id.imageButton -> {
                navController = Navigation.findNavController(requireView())
                val action = bundleOf("postName" to title, "id" to commentId)
                navController.navigate(R.id.action_addCommentFragment_to_commentsFragment, action)
            }
        }
    }

}