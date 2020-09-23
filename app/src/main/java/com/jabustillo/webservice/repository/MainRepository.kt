package com.jabustillo.webservice.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jabustillo.webservice.util.PreferenceProvider

object MainRepository {
    var logged = MutableLiveData<Boolean>()
    var loaded = MutableLiveData<Boolean>()
    var stateLogged : Boolean = false
    var stateLoaded : Boolean = false

    init {
        //stateLogged = PreferenceProvider.getValue()!!
        //logged.value = stateLogged;

    }

    fun getLogged() = logged as LiveData<Boolean>

    fun setLogged(state: Boolean){
        stateLogged = state
        logged.value = stateLogged;
        // PreferenceProvider.setValue(state)
    }

    fun getCoursesLoaded() = loaded as LiveData<Boolean>

    fun setCoursesLoaded(state: Boolean){
        stateLoaded = state
        logged.value = stateLogged;
        // PreferenceProvider.setValue(state)
    }

    fun createLogged(user: String, pass: String) {
        stateLogged = true
        logged.value = stateLogged;
        PreferenceProvider.setValue("user", user)
        PreferenceProvider.setValue("pass", pass)
        setLogged(true)
    }

    fun getValue(key: String) {
        PreferenceProvider.getValue(key)
    }
}