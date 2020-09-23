package com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.repository.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostsApiService {

    private val postsApi = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PostsApi::class.java)

    suspend fun getPosts(): List<Post> {
        return postsApi.getPosts()
    }

    suspend fun getPost(index : Int): Post {
        return postsApi.getPost(index)
    }

    suspend fun postAPost(post: Post): Post {
        return postsApi.postAPost(post)
    }

}