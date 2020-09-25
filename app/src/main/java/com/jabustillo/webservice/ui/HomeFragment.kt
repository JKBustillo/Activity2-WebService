package com.jabustillo.webservice.ui

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
import com.jabustillo.webservice.R
import com.jabustillo.webservice.model.Course
import com.jabustillo.webservice.util.PreferenceProvider
import com.jabustillo.webservice.viewmodel.CourseViewModel
import com.jabustillo.webservice.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_course.view.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private val homeViewModel: HomeViewModel by activityViewModels()
    private val courseViewModel: CourseViewModel by activityViewModels()
    private val adapter = CourseAdapter(ArrayList())
    lateinit var courses: List<Course>
//    val tok = PreferenceProvider.getValue("token")
    var textUser = "Hello, "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textUser = PreferenceProvider.getValue("user")
        tv_home.text = "Hello, $textUser"

        val navController = findNavController()

        homeViewModel.getLogged().observe(viewLifecycleOwner, Observer { logged ->
            if (logged == false) {
                navController.navigate(R.id.loginFragment)
            }
        })

        view.findViewById<Button>(R.id.logout).setOnClickListener {
            homeViewModel.setLogged(false)
        }

        view.findViewById<Button>(R.id.courses).setOnClickListener {
//            courseViewModel.getCourses(PreferenceProvider.getValue("user"), tok)
            navController.navigate(R.id.courseFragment)
        }

        view.findViewById<Button>(R.id.restartButton).setOnClickListener {
            courseViewModel.restartDB(PreferenceProvider.getValue("user"), PreferenceProvider.getValue("token"))
        }
    }
}