package com.kotlin.ttnpdev.mathproperties

import android.os.Bundle
import com.kotlin.ttnpdev.mathproperties.controller.bmi.ActivityBmi

class SecondActivity : ActivityBmi() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)
        activityBmi()
    }

}