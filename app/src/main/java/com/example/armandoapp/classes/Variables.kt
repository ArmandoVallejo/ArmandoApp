package com.example.armandoapp.classes

//class Variables {
    fun main(){

        // Numeric Variables
        val age:Int = 20
        val long_number:Long = 95875947594798
        val temperature:Float = 27.123f
        val weight:Double = 60.4

        //String Variables
        val gender:Char = 'M'
        val name:String = "Armando Vallejo"

        //Boolean Variables
        val isGreater:Boolean = true

        //Array
        val names = arrayOf("Gabriel", "Silvia", "Juan", "Renatta")

        println(age)
        println(long_number)
        println(temperature)
        println(weight)
        println(gender)
        println(name)
        println(isGreater)
        println(names[0])

        println("Welcome $name to your first Kotlin class")

        println(add())
        println(product(10,92))
    }

    fun add():Int{
        val x = 5
        val y = 10

        return x+y
    }

    fun product(x:Int, y:Int):Int{
        return x+y
    }
//}