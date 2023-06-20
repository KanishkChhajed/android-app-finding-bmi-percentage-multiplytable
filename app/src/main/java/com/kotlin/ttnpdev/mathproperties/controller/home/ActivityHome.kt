package com.kotlin.ttnpdev.mathproperties.controller.home

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.ttnpdev.mathproperties.FourthActivity
import com.kotlin.ttnpdev.mathproperties.R
import com.kotlin.ttnpdev.mathproperties.SecondActivity
import com.kotlin.ttnpdev.mathproperties.ThirthActivity
import com.kotlin.ttnpdev.mathproperties.controller.bmi.ActivityBmi

open class ActivityHome : AppCompatActivity() , View.OnClickListener {

    private lateinit var inflater : MenuInflater
    private lateinit var btBmi : ImageButton
    private lateinit var btPercentage : ImageButton
    private lateinit var btMultiplyTable : ImageButton
    private lateinit var intentForGoSomeWhere: Intent

    private fun getBt() {
        btBmi = findViewById(R.id.btBMI)
        btPercentage = findViewById(R.id.btPercentage)
        btMultiplyTable = findViewById(R.id.btMultiplyTable)
    }

    protected fun activityHome() {
        getBt()
        btBmi.setOnClickListener(this@ActivityHome)
        btPercentage.setOnClickListener(this@ActivityHome)
        btMultiplyTable.setOnClickListener(this@ActivityHome)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            btBmi.id -> {
                btBmi.setColorFilter(Color.rgb(61, 78, 44)) // change tint color
                Log.i("true","clicked button bmi")
                intentForGoSomeWhere = Intent(this@ActivityHome , SecondActivity::class.java )
                startActivity(intentForGoSomeWhere)
                /* Log.<> , it'll logging on Logcat */
            }
            btPercentage.id -> {
                btPercentage.setColorFilter(Color.rgb(50, 70, 36))
                intentForGoSomeWhere = Intent(this@ActivityHome , ThirthActivity::class.java )
                startActivity(intentForGoSomeWhere)
                Log.i("true","clicked button percentage")
            }
            btMultiplyTable.id -> {
                btMultiplyTable.setColorFilter(Color.rgb(61, 78, 44))
                intentForGoSomeWhere = Intent(this@ActivityHome , FourthActivity::class.java )
                startActivity(intentForGoSomeWhere)
                Log.i("true","clicked button multiply table")
            }
        }
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
                Toast.makeText(this@ActivityHome,R.string.toast_home,Toast.LENGTH_LONG).show()
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