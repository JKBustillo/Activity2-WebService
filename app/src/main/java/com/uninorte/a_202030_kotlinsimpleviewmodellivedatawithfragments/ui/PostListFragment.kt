package com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.R
import com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.repository.api.Post
import com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.viewmodel.PostViewModel
import kotlinx.android.synthetic.main.post_list_fragment.view.*

class PostListFragment : Fragment() {
    val postViewModel: PostViewModel by activityViewModels()
    private val adapter = PostsAdapter(ArrayList())
    lateinit var posts : List<Post>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.post_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // requireView gets the root view for the fragment's layout
        // (the one returned by onCreateView).
        requireView().posts_recycler.adapter = adapter
        requireView().posts_recycler.layoutManager = LinearLayoutManager(requireContext())

        // get the live data and start observing
        postViewModel.postsLiveData.observe(getViewLifecycleOwner(), Observer {
                adapter.posts.clear()
                adapter.posts.addAll(it)
                adapter.notifyDataSetChanged()
        })

        view.findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {
            postViewModel.getPost()
        }
    }

}