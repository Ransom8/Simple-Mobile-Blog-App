package com.example.week11_architecture.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.week11_architecture.R
import com.example.week11_architecture.adapter.OnClick
import kotlinx.android.synthetic.main.fragment_add_comment.*
import kotlin.properties.Delegates

class AddCommentFragment : Fragment(R.layout.fragment_add_comment), View.OnClickListener, OnClick {

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

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.addComment, R.id.imageButton -> {
                navController = Navigation.findNavController(requireView())
                val action = bundleOf("postName" to title, "id" to commentId)
                navController.navigate(R.id.action_addCommentFragment_to_commentsFragment, action)
            }
        }
    }

}