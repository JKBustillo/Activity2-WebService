package com.jabustillo.webservice.viewmodel

import androidx.lifecycle.ViewModel
import com.jabustillo.webservice.repository.MainRepository

class RegisterViewModel : ViewModel() {
    private val mainRepository = MainRepository
    fun getLogged() = mainRepository.getLogged()
    fun setValue(user: String, pass: String){
        mainRepository.createLogged(user, pass)
    }
}