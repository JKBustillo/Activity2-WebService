package com.jabustillo.webservice.repository

import com.jabustillo.webservice.repository.api.course.CourseApiService

class CourseRepository {

    private val service = CourseApiService()

    suspend fun getCourses(user: String, token: String) = service.getCourses(user,token)

    fun addCourse(user: String, token: String) = service.addCourse(user,token)

    fun getCourseData() = service.getCourseData()
}