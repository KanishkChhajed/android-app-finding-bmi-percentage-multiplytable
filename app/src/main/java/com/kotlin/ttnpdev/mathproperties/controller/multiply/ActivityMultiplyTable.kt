package com.kotlin.ttnpdev.mathproperties.controller.multiply

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

open class ActivityMultiplyTable : AppCompatActivity() , View.OnClickListener {

    private lateinit var inflater : MenuInflater
    private lateinit var intentToHome:Intent
    private lateinit var editeTextInputTable:EditText
    private lateinit var textViewResultMultiplyTable:TextView
    private lateinit var buttonMultiplyTable:AppCompatButton

    private fun getWidgetFirst() {
        buttonMultiplyTable = findViewById(R.id.buttonMultiplyTable)
    }

    private fun getWidgetSecond() {
        editeTextInputTable = findViewById(R.id.editeTextInputTable)
        textViewResultMultiplyTable = findViewById(R.id.textViewResultMultiplyTable)
    }
    private fun process() {
        getWidgetSecond()
        if (ServiceLogic.validateTable(editeTextInputTable.text.toString())) {
            // Log.i("request", "accepted")
            textViewResultMultiplyTable.setTextColor(ContextCompat.getColor(this@ActivityMultiplyTable,R.color.result_multiply_table))
            textViewResultMultiplyTable.text = ServiceLogic.getMultiplyTable(editeTextInputTable.text.toString().toInt())
        }
        else{
            val resultText = "Found some empty values"
            // Log.e("request", "not accepted")
            textViewResultMultiplyTable.setTextColor(ContextCompat.getColor(this@ActivityMultiplyTable,R.color.bad_input))
            textViewResultMultiplyTable.text = resultText
        }
    }
    protected fun activityMultiplyTable() {
        getWidgetFirst()
        buttonMultiplyTable.setOnClickListener(this@ActivityMultiplyTable)
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
                intentToHome = Intent(this@ActivityMultiplyTable, MainActivity::class.java)
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