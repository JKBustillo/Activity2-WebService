package com.jabustillo.webservice.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jabustillo.webservice.R
import com.jabustillo.webservice.model.Course
import com.jabustillo.webservice.util.PreferenceProvider
import com.jabustillo.webservice.viewmodel.CourseViewModel
import kotlinx.android.synthetic.main.fragment_course.view.*

class CourseFragment : Fragment() {
    private val courseViewModel: CourseViewModel by activityViewModels()
    private val adapter = CourseAdapter(ArrayList())
    lateinit var courses: List<Course>
    val algo = PreferenceProvider.getValue("token")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        courseViewModel.getCourses("elprofesor", algo)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_course, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        courses = courseViewModel.getCourses("elprofesor", PreferenceProvider.getValue("token"))
        requireView().courses_recycle.adapter = adapter
        requireView().courses_recycle.layoutManager = LinearLayoutManager(requireContext())


        courseViewModel.coursesLiveData.observe(viewLifecycleOwner, Observer {
            adapter.items?.clear()
            adapter.items?.addAll(it)
            adapter.notifyDataSetChanged()
        })

        view.findViewById<Button>(R.id.updateCoursesButton).setOnClickListener {
            courseViewModel.getCourses("elprofesor", algo)
        }

        view.findViewById<Button>(R.id.addCourseButton).setOnClickListener {
            courseViewModel.addCourse("elprofesor", algo)
        }
    }
}