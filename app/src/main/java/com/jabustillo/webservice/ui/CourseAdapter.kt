package com.jabustillo.webservice.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jabustillo.webservice.R
import com.jabustillo.webservice.model.Course
import kotlinx.android.synthetic.main.course_item.view.*

class CourseAdapter(items: ArrayList<Course>): RecyclerView.Adapter<CourseAdapter.ViewHolder>() {
    var items : ArrayList<Course>? = null
    var viewHolder: ViewHolder? = null

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseAdapter.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.course_item, parent, false)

        viewHolder = ViewHolder(view)

        return viewHolder!!
    }

    override fun onBindViewHolder(holder: CourseAdapter.ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.name?.text = item?.name
        holder.id?.text = item?.id
    }

    override fun getItemCount(): Int {
        return this.items?.count()!!
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var view = view

        var id: TextView? = null
        var name : TextView? = null

        init {
            id = view.tvCourseId
            name = view.tvCourseName
        }
    }

}