package com.kotlin.ttnpdev.mathproperties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.ttnpdev.mathproperties.controller.home.ActivityHome

class MainActivity : ActivityHome() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        activityHome()
    }
}