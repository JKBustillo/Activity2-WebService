package com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.uninorte.a_2020_bindingclick.data.User

object MyRepository {
    private var userList = mutableListOf<User>()
    private val users = MutableLiveData<List<User>>()

    fun getUsers() = users as LiveData<List<User>>

    fun addUser(user: User) {
        userList.add(user)
        users.value = userList
    }
}