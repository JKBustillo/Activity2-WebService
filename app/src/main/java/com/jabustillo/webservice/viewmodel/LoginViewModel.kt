package com.jabustillo.webservice.viewmodel

import androidx.lifecycle.ViewModel
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
}