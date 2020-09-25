package com.jabustillo.webservice.repository.api.course

import com.jabustillo.webservice.model.Course
import com.jabustillo.webservice.model.CourseDetail
import com.jabustillo.webservice.model.Student
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

    @GET("{dbId}/restart")
    fun restartDB(
            @Path("dbId") user: String,
            @Header ("Authorization") header: String
    ): Call<Boolean>

    @GET("{dbId}/professors/{professorId}")
    fun getProfessorData(
            @Path("dbId") user: String,
            @Path("professorId") professor: String,
            @Header ("Authorization") header: String
    ): Call<Student>

    @GET("{dbId}/students/{studentId}")
    fun getStudentData(
            @Path("dbId") user: String,
            @Path("studentId") student: String,
            @Header ("Authorization") header: String
    ): Call<Student>

    @FormUrlEncoded
    @POST("{dbId}/students")
    fun addStudent(
        @Path("dbId") user: String,
        @Header ("Authorization") header: String,
        @Field("courseId") courseId: String
    ): Call<Student>

}