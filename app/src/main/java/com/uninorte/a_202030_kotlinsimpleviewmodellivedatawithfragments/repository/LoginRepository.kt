package com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.repository

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.util.PreferenceProvider
import com.uninorte.a_2020_bindingclick.data.User

object LoginRepository {
    var logged = MutableLiveData<Boolean>()
    var stateLogged : Boolean = false

    init {
        stateLogged = PreferenceProvider.getValue()!!
        logged.value = stateLogged;
    }

    fun getLogged() = logged as LiveData<Boolean>

    fun setLogged(state: Boolean){
        stateLogged = state
        logged.value = stateLogged;
        PreferenceProvider.setValue(state)
    }
}