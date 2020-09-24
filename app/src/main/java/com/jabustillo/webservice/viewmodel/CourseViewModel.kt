package com.jabustillo.webservice.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jabustillo.webservice.model.Course
import com.jabustillo.webservice.model.CourseDetail
import com.jabustillo.webservice.model.Student
import com.jabustillo.webservice.repository.CourseRepository
import kotlinx.coroutines.launch
import okhttp3.internal.notify

class CourseViewModel : ViewModel() {

    private val repository = CourseRepository()
    val courses = mutableListOf<Course>()
    val coursesLiveData = MutableLiveData<List<Course>>()
    val courseDetailLiveData = MutableLiveData<CourseDetail>()
    var courseDetail = CourseDetail("", Student("","", "", "", "", "", "", ""), emptyList<Student>())
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

    fun getCourseData(user: String, id: String,  token: String) {
        viewModelScope.launch {
            var course = id.subSequence(4, id.length) as String
            val returnCourseDetail: CourseDetail = repository.getCourseData(user, course, token)
            courseDetail = returnCourseDetail
            coursesLiveData.postValue(courses.asReversed())
        }
    }

}