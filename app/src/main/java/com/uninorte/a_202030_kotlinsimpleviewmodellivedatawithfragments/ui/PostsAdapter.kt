package com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.R
import com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.repository.api.Post
import kotlinx.android.synthetic.main.list_item_post.view.*

class PostsAdapter(val posts: ArrayList<Post>): RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_post, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: Post) {
            itemView.title.text = post.title
            itemView.body.text = post.body
        }
    }
}