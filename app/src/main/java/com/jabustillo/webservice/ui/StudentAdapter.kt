package com.jabustillo.webservice.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.jabustillo.webservice.R
import com.jabustillo.webservice.model.Student
import com.jabustillo.webservice.model.StudentResume
import com.jabustillo.webservice.util.PreferenceProvider
import kotlinx.android.synthetic.main.course_item.view.*
import kotlinx.android.synthetic.main.student_item.view.*

class StudentAdapter(items: MutableList<StudentResume>): RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    var items : MutableList<StudentResume>? = null
    var viewHolder: ViewHolder? = null

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapter.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.student_item, parent, false)

        viewHolder = ViewHolder(view)

        return viewHolder!!
    }

    override fun onBindViewHolder(holder: StudentAdapter.ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.id?.text = item?.id
        holder.name?.text = item?.name
        holder.username?.text = item?.username
        holder.email?.text = item?.email
//        holder.phone?.text = item?.phone
//        holder.city?.text = item?.city
//        holder.country?.text = item?.country
//        holder.birthday?.text = item?.birthday
    }

    override fun getItemCount(): Int {
        return this.items?.count()!!
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var view = view

        var id: TextView? = null
        var name : TextView? = null
        var username : TextView? = null
        var email : TextView? = null
//        var phone: TextView? = null
//        var city: TextView? = null
//        var country: TextView? = null
//        var birthday: TextView? = null

        init {
            id = view.idStudentDetails
            name = view.userStudentDetails
            username = view.usernameStudentDetails
            email = view.emailStudentDetails
            PreferenceProvider.setValue("studentId", id.toString())
            view.setOnClickListener {
                view.findNavController().navigate(R.id.studentInfoFragment)
            }
        }
    }

}