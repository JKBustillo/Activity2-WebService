package com.jabustillo.webservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jabustillo.webservice.util.PreferenceProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PreferenceProvider.initialize(this)
    }
}