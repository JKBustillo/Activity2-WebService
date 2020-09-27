package com.jabustillo.webservice.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jabustillo.webservice.R
import com.jabustillo.webservice.util.PreferenceProvider
import com.jabustillo.webservice.viewmodel.CourseViewModel
import kotlinx.android.synthetic.main.fragment_course_info.*
import kotlinx.android.synthetic.main.fragment_student_info.*

class StudentInfoFragment : Fragment() {
    var courseId : String = PreferenceProvider.getValue("studentId")
    var token : String = PreferenceProvider.getValue("token")
    private val courseViewModel: CourseViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_info, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        courseViewModel.studentDetailLiveData.observe(viewLifecycleOwner,  {student ->

            idUserInfoDetails.text = student?.id
            userUserInfoDetails.text = student?.name
            usernameUserInfoDetails.text = student?.username
            emailUserInfoDetails.text = student?.email
            phoneUserInfoDetails.text = student?.phone
            cityUserInfoDetails.text = student?.city
            countryUserInfoDetails.text = student?.country
            birthdayUserInfoDetails.text = student?.birthday
        })

        view.findViewById<Button>(R.id.update).setOnClickListener {
            courseViewModel.getStudentData(PreferenceProvider.getValue("user"), courseId, token)

        }
    }
}