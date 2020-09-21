package com.jabustillo.webservice.viewmodel

import androidx.lifecycle.ViewModel
import com.jabustillo.webservice.repository.MainRepository

class HomeViewModel: ViewModel() {
    private val mainRepository = MainRepository
    fun getLogged() = mainRepository.getLogged()
    fun setLogged(state: Boolean){
        mainRepository.setLogged(state)
    }
}