package com.kotlin.ttnpdev.mathproperties.controller.percentage

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


open class ActivityPercentage : AppCompatActivity () , View.OnClickListener {

    private lateinit var inflater : MenuInflater
    private lateinit var intentToHome:Intent
    private lateinit var editTextInputA: EditText
    private lateinit var editTextInputB: EditText
    private lateinit var buttonBmi: AppCompatButton
    private lateinit var textViewResultPercentage : TextView

    private fun getWidgetSecond() {
        editTextInputA = findViewById(R.id.editeTextInputA)
        editTextInputB = findViewById(R.id.editeTextInputB)
    }
    private fun getWidgetFirst() {
        buttonBmi = findViewById(R.id.buttonBmi)
    }

    private fun getWidgetThirth() {
        textViewResultPercentage = findViewById(R.id.textViewResultPercentage)
    }

    protected fun activityPercentage() {
        getWidgetFirst()
        buttonBmi.setOnClickListener(this@ActivityPercentage)
    }

    private fun getTodoTrue(inputA : Float , inputB:Float) {
        getWidgetThirth()
        val resultPercentage = ServiceLogic.findPercentage(inputA, inputB)
        Log.i("resultPercentage", "$resultPercentage")
        val resultText = "Input $inputA is ${String.format("%.2f",resultPercentage)}% of Input $inputB"
        textViewResultPercentage.setTextColor(ContextCompat.getColor(this@ActivityPercentage,R.color.result_percentage))
        textViewResultPercentage.text = resultText
    }

    private fun getTodoFalse() {
        getWidgetThirth()
        val resultText = "Found some empty values"
        textViewResultPercentage.setTextColor(ContextCompat.getColor(this@ActivityPercentage,R.color.bad_input))
        textViewResultPercentage.text = resultText
    }

    private fun process() {
        getWidgetSecond()
        if (ServiceLogic.validateInputAAndB(editTextInputA.text.toString(),editTextInputB.text.toString())) {
            // Log.i("info", "good request",)
            getTodoTrue(editTextInputA.text.toString().toFloat(),editTextInputB.text.toString().toFloat())
        }
        else {
            // Log.e("warn", "edit text shouldn't be empty")
            getTodoFalse()
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
                intentToHome = Intent(this@ActivityPercentage, MainActivity::class.java)
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