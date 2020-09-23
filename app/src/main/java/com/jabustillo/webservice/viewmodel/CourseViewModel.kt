package com.jabustillo.webservice.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jabustillo.webservice.model.Course
import com.jabustillo.webservice.repository.CourseRepository
import kotlinx.coroutines.launch
import okhttp3.internal.notify

class CourseViewModel : ViewModel() {

    private val repository = CourseRepository()
    val courses = mutableListOf<Course>()
    val coursesLiveData = MutableLiveData<List<Course>>()

    // fun getCourses(user: String, token: String) = repository.getCourses(user, token)

    fun getCourses(user: String, token: String){
        viewModelScope.launch {
            val theReturnCourse = repository.getCourses(user, token)
            courses.addAll(theReturnCourse)
            coursesLiveData.postValue(courses.asReversed())
        }
    }

    fun addCourse(user: String, token: String)  {
        Log.d("MyOut", "CourseViewModel addCourses with token  <" + token+">")
        repository.addCourse(user, token)
    }

    fun getCourseData() = repository.getCourseData()

}