package com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.repository.LoginRepository

class LoginViewModel : ViewModel() {
    private val loginRepository = LoginRepository
    fun getLogged() = loginRepository.getLogged()
    fun setLogged(state: Boolean){
        loginRepository.setLogged(state)
    }
}
