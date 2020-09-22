package com.jabustillo.webservice.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jabustillo.webservice.model.User
import com.jabustillo.webservice.repository.api.login.LoginApiService

class LoginRepository {

    var userLiveData = MutableLiveData<User>()

    private val service = LoginApiService()

    fun signIn(user: User) = service.signIn(user)

    fun signUp(user: User) = service.signUp(user)

    fun getUser() = userLiveData as LiveData<User>

}