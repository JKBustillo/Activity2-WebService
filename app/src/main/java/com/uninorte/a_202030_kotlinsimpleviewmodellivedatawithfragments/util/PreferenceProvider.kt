package com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.util

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class PreferenceProvider {
    companion object {
        lateinit var preference : SharedPreferences
        fun initialize(context: Context) {
            preference = context.getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE)
        }

        fun setValue(value: Boolean){
            preference.edit().putBoolean("key",value).apply()
        }
        fun getValue(): Boolean? {
            return preference.getBoolean("key",false)
        }
    }
}