package com.kotlin.ttnpdev.mathproperties

import android.os.Bundle
import com.kotlin.ttnpdev.mathproperties.controller.multiply.ActivityMultiplyTable

class FourthActivity : ActivityMultiplyTable() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplt_table)
        activityMultiplyTable()
    }
}