package com.kotlin.ttnpdev.mathproperties.controller.bmi

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.kotlin.ttnpdev.mathproperties.MainActivity
import com.kotlin.ttnpdev.mathproperties.R
import com.kotlin.ttnpdev.mathproperties.controller.service.ServiceLogic

open class ActivityBmi : AppCompatActivity() , View.OnClickListener {

    private lateinit var inflater : MenuInflater
    private lateinit var intentToHome: Intent
    private lateinit var editTextWeight : EditText
    private lateinit var editTextHeight : EditText
    private lateinit var buttonBmi : AppCompatButton
    private lateinit var textViewResultBmi : TextView
    private lateinit var textViewResultMessage : TextView

    private fun getWidgetFirst() {
        editTextHeight = findViewById(R.id.editeTextHeight)
        editTextWeight = findViewById(R.id.editeTextWeight)
        buttonBmi = findViewById(R.id.buttonBmi)
    }
    private fun getWidgetSecond() {
        textViewResultBmi = findViewById(R.id.textViewResultBmi)
        textViewResultMessage = findViewById(R.id.textViewResultMessage)
    }

    protected fun activityBmi() {
        getWidgetFirst()
        buttonBmi.setOnClickListener(this@ActivityBmi)
    }

    private fun toDoFalse(bmi:Float) {
        textViewResultBmi.setTextColor(ContextCompat.getColor(this@ActivityBmi,R.color.bad_input))
        textViewResultBmi.text = bmi.toString()
        textViewResultMessage.setTextColor(ContextCompat.getColor(this@ActivityBmi,R.color.bad_input))
        textViewResultMessage.text = "Found some empty values"
    }

    private fun toDoTrue(bmi:Float) {

        val message= if ((bmi >= 0) && (bmi <= 24.99)) {
            /*
                (More than once way)
                change color from widget  Note : ContextCompat.getColor(this,color)
                Returns a color associated with a particular resource ID
            */
            textViewResultBmi.setTextColor(ContextCompat.getColor(this@ActivityBmi,R.color.result_bmi))
            textViewResultMessage.setTextColor(ContextCompat.getColor(this@ActivityBmi,R.color.nice_input))

            "Pretty , Bmi" // set default message value
        } else {
            textViewResultBmi.setTextColor(ContextCompat.getColor(this@ActivityBmi,R.color.result_bmi))
            textViewResultMessage.setTextColor(ContextCompat.getColor(this@ActivityBmi,R.color.bad_input))

            "Dangerous , Bmi" // set default message value
        }
        textViewResultBmi.text = String.format("%.2f",bmi)
        textViewResultMessage.text = message
    }

    private fun process() {
        getWidgetSecond()
        val bmi : Float
        if (ServiceLogic.validateWeightHeightText(editTextWeight.text.toString() , editTextHeight.text.toString())) {
            bmi = ServiceLogic.findBmi(editTextWeight.text.toString().toFloat(),editTextHeight.text.toString().toFloat())
            // Log.i("true","weight & height were perfect input")
            // Log.i("bmi","$bmi")
            toDoTrue(bmi)
        }
        else {
            // Log.e("false","bad request")
            bmi = 0.0F
            toDoFalse(bmi)
        }
    }
    override fun onClick(v: View?) {
        process()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        /* function onCreateOptionsMenu() for getting menu from xml file */
        inflater = menuInflater
        inflater.inflate(R.menu.navigate_main , menu) // add menu
        return true
        /* that's it */
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        /*
           When the user selects an item from the options menu
           (including action items in the app bar)
           the system calls your activity's onOptionsItemSelected()
        */
        return when (item.itemId) {
            // Handle item selection
            R.id.item_child_home -> {
                intentToHome = Intent(this@ActivityBmi,MainActivity::class.java)
                startActivity(intentToHome)
                true
            }
            R.id.item_child_contact -> {
                /*  set the intent for taking some url */
                val intentForGotoUrl = Intent(Intent.ACTION_VIEW)
                intentForGotoUrl.data = Uri.parse("https://github.com/ttknpde-v") /* specify url */
                startActivity(intentForGotoUrl) /* The startActivity() method starts the Intent.  */
                true
            }
            else -> super.onOptionsItemSelected(item) // when don't click , should set super class because it'll return false
        }
    }

}