package com.uninorte.a_2020_kotlinsimpleviewmodellivedatavideo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.repository.MyRepository
import com.uninorte.a_2020_bindingclick.data.User

class MyViewModel : ViewModel(){
    private val myRepository = MyRepository
    fun getUsers() = myRepository.getUsers()
    fun addUser(user: User) = myRepository.addUser(user)
}