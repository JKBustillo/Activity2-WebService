package com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.repository.api

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

//A suspending function is simply a function that can be paused and resumed at a later time
interface PostsApi {
    @GET("posts/")
    suspend fun getPosts(): List<Post>

    @GET("posts/{index}/")
    suspend fun getPost(@Path("index") index: Int): Post

    @POST("posts/")
    suspend fun postAPost(@Body post: Post): Post
}
