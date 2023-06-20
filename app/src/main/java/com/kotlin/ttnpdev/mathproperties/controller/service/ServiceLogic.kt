package com.kotlin.ttnpdev.mathproperties.controller.service
/*
   Learn Object class (not allowed construct inside object class)
*  Object declaration can inherit from classes and interfaces in a similar way like normal classes.
*  call them without declare any object
* */
object ServiceLogic {

    internal fun findBmi(weight:Float , height:Float) : Float = weight / ( (height/100) * (height/100) )

    internal fun findPercentage (inputA : Float , inputB:Float) : Float = (inputA*100)/inputB

    internal fun getMultiplyTable (n:Int) : String{
        var table = ""
        for (i in 1 ..10) {
            table += "$n x $i equal ${n*i}\n"
        }
        return table
    }

    internal fun validateInputAAndB (inputA : String , inputB:String) : Boolean {
        var bool = false
        if (inputA.trim().isNotEmpty() && inputB.trim().isNotEmpty() && inputB.trim().toFloat() != 0F) {
            bool = true
        }
        return bool
    }

    internal fun validateWeightHeightText(weight:String , height:String) : Boolean {
        /* can write : bool = (weight.trim().isNotEmpty()) && (height.trim().isNotEmpty()) */
        var bool = false
        if ((weight.trim().isNotEmpty()) && (height.trim().isNotEmpty())) {
            bool = true
        }
        return bool
    }

    internal fun validateTable(n:String) : Boolean {
        var bool = false
        if (n.trim().isNotEmpty()) {
            bool = true
        }
        return bool
    }



}
