package com.jabustillo.webservice.util

import android.content.Context
import android.content.SharedPreferences

class PreferenceProvider {
    companion object {
        lateinit var preference : SharedPreferences

        fun initialize(context: Context) {
            preference = context.getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE)
        }

        /*fun setValue(value: Boolean){
            preference.edit().putBoolean("key",value).apply()
        }*/

        fun setValue(key: String, value: String) {
            preference.edit().putString(key, value).apply()
        }

        fun getValue(key: String): String {
            return preference.getString(key, "").toString()
        }

        /*fun getValue(): Boolean? {
            return preference.getBoolean("key",false)
        }*/
    }
}