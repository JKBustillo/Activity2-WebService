package com.jabustillo.webservice.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.jabustillo.webservice.R
import com.jabustillo.webservice.model.Course
import kotlinx.android.synthetic.main.course_item.view.*
import androidx.navigation.fragment.findNavController
import com.jabustillo.webservice.util.PreferenceProvider


class   CourseAdapter(items: MutableList<Course>): RecyclerView.Adapter<CourseAdapter.ViewHolder>() {
    var items : MutableList <Course>? = null
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
        holder.name?.text = "Name: " + item?.name
        holder.id?.text = "Id: " + item?.id
        holder.professor?.text = "Professor: " + item?.professor
        holder.students?.text = "# of Students: " + item?.students
    }

    override fun getItemCount(): Int {
        return this.items?.count()!!
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
//        var view = view

        var id: TextView? = null
        var name : TextView? = null
        var professor : TextView? = null
        var students : TextView? = null

        init {
            id = view.tvCourseId
            name = view.tvCourseName
            professor = view.tvProfessorCourse
            students = view.tvStudentsCourse
            view.setOnClickListener {
                val tempId  = it.tvCourseId.text.toString()
                PreferenceProvider.setValue("courseId", tempId.substring(4, tempId.length))
                view.findNavController().navigate(R.id.courseInfoFragment)
            }
        }



    }

}