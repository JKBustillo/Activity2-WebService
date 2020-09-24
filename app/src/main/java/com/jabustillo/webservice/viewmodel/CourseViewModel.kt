package com.jabustillo.webservice.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jabustillo.webservice.model.Course
import com.jabustillo.webservice.model.CourseDetail
import com.jabustillo.webservice.model.Student
import com.jabustillo.webservice.model.StudentResume
import com.jabustillo.webservice.repository.CourseRepository
import com.jabustillo.webservice.repository.MainRepository
import kotlinx.coroutines.launch
import okhttp3.internal.notify

class CourseViewModel : ViewModel() {
    private val mainRepository = MainRepository
    private val repository = CourseRepository()
    private val courses = mutableListOf<Course>()
    val coursesLiveData = MutableLiveData<List<Course>>()
    val courseDetailLiveData = MutableLiveData<CourseDetail>()
    private val courseDetail = CourseDetail("", StudentResume(), emptyList<StudentResume>() )


    fun getCoursesLoaded() = mainRepository.getCoursesLoaded()

    fun setCoursesLoaded(state: Boolean){
        mainRepository.setCoursesLoaded(state)
    }

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
        Log.d("TestStudents", "Algo")
        viewModelScope.launch {
            var course = id as String
            val returnCourseDetail: CourseDetail = repository.getCourseData(user, course, token)
            courseDetail.name = returnCourseDetail.name
            courseDetail.professor = returnCourseDetail.professor
            courseDetail.student = returnCourseDetail.student
            courseDetailLiveData.postValue(returnCourseDetail)
        }
    }

}