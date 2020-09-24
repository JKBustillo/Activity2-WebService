package com.jabustillo.webservice.repository.api.course

import com.jabustillo.webservice.model.Course
import com.jabustillo.webservice.model.CourseDetail
import retrofit2.Call
import retrofit2.http.*

interface CourseApi {

    @GET("{dbId}/courses")
    fun getCourses(
        @Path("dbId") user: String,
        @Header ("Authorization") header: String
    ): Call<List<Course>>

    @GET("{dbId}/courses/{courseId}")
    fun getCourseData(
        @Path("dbId") user: String,
        @Path("courseId") course: String,
        @Header ("Authorization") header: String
    ): Call<CourseDetail>

    @POST("{dbId}/courses")
    fun addCourse(@Path("dbId") user: String, @Header ("Authorization") header: String): Call<Course>

}