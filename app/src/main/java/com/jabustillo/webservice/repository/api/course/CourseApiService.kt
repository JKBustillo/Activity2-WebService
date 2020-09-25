package com.jabustillo.webservice.repository.api.course


import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jabustillo.webservice.model.Course
import com.jabustillo.webservice.model.CourseDetail
import com.jabustillo.webservice.model.Student
import com.jabustillo.webservice.model.StudentResume
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class CourseApiService {

    companion object{

        val theResponse = MutableLiveData<List<Course>>()
        var courses = mutableListOf<Course>()
        var courseDetail = CourseDetail("", StudentResume(), emptyList<StudentResume>())
        fun getRestEngine(): CourseApi {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            return Retrofit.Builder()
                .baseUrl("https://movil-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(CourseApi::class.java)

        }
    }

    fun restartDB(user: String, token: String) : Boolean {
        var result : Boolean = false
        //Log.d("MyOut", "getCourses with token  <" + token+">")
        val auth = "Bearer "+token
        getRestEngine().restartDB(user,auth).enqueue(object: Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                if (response.isSuccessful) {
                    Log.d("MyOut", "OK isSuccessful ")
                    val loginResponse = response.body()
                    if (loginResponse != null) {
                        result = response.body() as Boolean
                    }
                } else {
                    Log.d("MyOut", "NOK  "+response.code() )
                    Log.d("MyOut", "NOK  "+response.toString() )
                    Log.d("MyOut", "NOK  "+response.errorBody().toString() )
                }
            }

            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                Log.d("MyOut","Failure "+t.message)
            }
        })
        return result
    }

    fun getCourseData(user: String, course: String, token: String) : CourseDetail {
        //Log.d("MyOut", "getCourses with token  <" + token+">")
        val auth = "Bearer "+token
        getRestEngine().getCourseData(user,course,auth).enqueue(object: Callback<CourseDetail> {
            override fun onResponse(call: Call<CourseDetail>, response: Response<CourseDetail>) {
                if (response.isSuccessful) {
                    Log.d("MyOut", "OK isSuccessful ")
                    val loginResponse = response.body()
                    if (loginResponse != null) {
                        //theResponse.value = response.body()
                        courseDetail = response.body() as CourseDetail
                    }
                } else {
                    Log.d("MyOut", "NOK  "+response.code() )
                    Log.d("MyOut", "NOK  "+response.toString() )
                    Log.d("MyOut", "NOK  "+response.errorBody().toString() )
                }
            }

            override fun onFailure(call: Call<CourseDetail>, t: Throwable) {
                Log.d("MyOut","Failure "+t.message)
            }

        })
        Log.d("something", "Course $courseDetail")
        return courseDetail!!
    }


    fun getCourses(user: String, token: String): List<Course> {

        //Log.d("MyOut", "getCourses with token  <" + token+">")
        val auth = "Bearer "+token
        getRestEngine().getCourses(user,auth).enqueue(object: Callback<List<Course>>{
            override fun onResponse(call: Call<List<Course>>, response: Response<List<Course>>) {
                if (response.isSuccessful) {
                    //Log.d("MyOut", "OK isSuccessful ")
                    val loginResponse = response.body()
                    if (loginResponse != null) {
                        //theResponse.value = response.body()
                        theResponse.postValue(response.body())
                        courses.clear()
                        val t = response.body() as List<Course>
                        courses.addAll(t)
                        theResponse.postValue(courses)
                    }
                } else {
                    Log.d("MyOut", "NOK  "+response.code() )
                    Log.d("MyOut", "NOK  "+response.toString() )
                    Log.d("MyOut", "NOK  "+response.errorBody().toString() )
                }
            }

            override fun onFailure(call: Call<List<Course>>, t: Throwable) {
                Log.d("MyOut","Failure "+t.message)
            }

        })
        return courses
    }

    fun addCourse(user: String, token: String) {

        Log.d("MyOut", "addCourse with token  <" + token+">")
        val auth = "Bearer "+token
        getRestEngine().addCourse(user,auth).enqueue(object: Callback<Course>{
            override fun onResponse(call: Call<Course>, response: Response<Course>) {
                if (response.isSuccessful) {
                    Log.d("MyOut", "OK isSuccessful ")
                    val loginResponse = response.body()
                    if (loginResponse != null) {
                        //Log.d("MyOut", "OK isSuccessful token " )
                        courses.add(response.body()!!)
                        Companion.theResponse.postValue(courses)
                    }
                } else {
                    Log.d("MyOut", "NOK  "+response.code() )
                    Log.d("MyOut", "NOK  "+response.toString() )
                    Log.d("MyOut", "NOK  "+response.errorBody().toString() )
                }
            }

            override fun onFailure(call: Call<Course>, t: Throwable) {
                Log.d("MyOut","Failure "+t.message)
            }

        })
    }

}