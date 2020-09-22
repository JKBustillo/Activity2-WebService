package com.jabustillo.webservice.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jabustillo.webservice.model.User
import com.jabustillo.webservice.repository.LoginRepository
import com.jabustillo.webservice.repository.MainRepository

class LoginViewModel: ViewModel() {
    private val mainRepository = MainRepository
    fun getLogged() = mainRepository.getLogged()
    fun setLogged(state: Boolean){
        mainRepository.setLogged(state)
    }
    fun getValue(key: String) {
        mainRepository.getValue(key).toString()
    }

    var userLiveData = MutableLiveData<User>()

    private val repository = LoginRepository()

    fun signIn(email: String, clave: String, usuario : String) =
        repository.signIn(User(email, clave, usuario, usuario,"",""))

    fun signUp(email: String, clave: String, usuario : String) =
        repository.signUp(User(email, clave, usuario, usuario,"",""))

    fun getUser() = userLiveData
}