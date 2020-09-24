package com.jabustillo.webservice.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.jabustillo.webservice.R
import com.jabustillo.webservice.model.Course
import com.jabustillo.webservice.model.CourseDetail
import com.jabustillo.webservice.model.Student
import com.jabustillo.webservice.util.PreferenceProvider
import com.jabustillo.webservice.viewmodel.CourseViewModel
import kotlinx.android.synthetic.main.fragment_course_info.*
import java.util.Observer

class CourseInfoFragment : Fragment() {
    private val courseViewModel: CourseViewModel by activityViewModels()
    var courseId : String = PreferenceProvider.getValue("courseId")
    var token : String = PreferenceProvider.getValue("token")
    var courseDetail = CourseDetail("", Student("","", "", "", "", "", "", ""), emptyList<Student>())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        courseViewModel.getCourseData("elprofesor", courseId, token)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        idCourseDetails.text = courseId
    }
}