package com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments

import android.app.Application
import android.util.Log
import com.uninorte.a_202030_kotlinsimpleviewmodellivedatawithfragments.util.PreferenceProvider

class AppClass : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("VideoViewModel","AppClass onCreate")
        PreferenceProvider.initialize(this)
    }
}

