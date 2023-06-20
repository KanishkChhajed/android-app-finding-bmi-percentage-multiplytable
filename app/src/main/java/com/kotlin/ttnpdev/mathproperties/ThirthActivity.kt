package com.kotlin.ttnpdev.mathproperties

import android.os.Bundle
import com.kotlin.ttnpdev.mathproperties.controller.percentage.ActivityPercentage

class ThirthActivity : ActivityPercentage() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_percentage)
        activityPercentage()
    }
}