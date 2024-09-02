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
        printArray(names)
        println(names.joinToString())

        val numbers = arrayOf(1,2,3,4,5,6,7,8,9)
        isEven(numbers)

        println(getDay(2))

        val person = Person("Juan", 22)
        println(person.name)
        println(person.age)

        person.displayInformation()
    }

    fun add():Int{
        val x = 5
        val y = 10

        return x+y
    }

    fun product(x:Int, y:Int):Int{
        return x+y
    }

    fun printArray(names:Array<String>){
        for (name in names){
            print("Hello $name, ")
        }
    }

    fun isEven(numbers:Array<Int>){
        for (number in numbers){
            if (number%2==0){
                println("$number is even")
            }
            else{
                println("$number is odd")
            }
        }
    }

    fun getDay(day:Int):String{
        var name = ""

        when(day){
            1 -> name = "Monday"
            2 -> name = "Tuesday"
            3 -> name = "Wednesday"
            4 -> name = "Thursday"
            5 -> name = "Friday"
            6 -> name = "Saturday"
            7 -> name = "Sunday"
            else -> name = "Incorrect value"
        }

        return name
    }

    class Person (val name:String, val age:Int){
        fun displayInformation(){
            println("Name: $name, Age: $age")
        }
    }


//}