package com.edutilos.kotlin.main

import java.util.*


fun main(args: Array<String>) {
    val rand = Random()
    var x = rand.nextDouble()* 100
    var y = rand.nextDouble()* 100


  var add = StaticMath.add(x, y)
    var sub = StaticMath.sub(x, y)
    var mult = StaticMath.mult(x , y)
    var div = StaticMath.div(x , y)

    println("$x + $y = $add")
    println("$x - $y = $sub")
    println("$x * $y = $mult")
    println("$x / $y = $div")


     var scanner = Scanner(System.`in`)
    var name:String
    var age:Int
    var wage:Double

    println("insert name, age, wage : ")
    var input:String = scanner.nextLine()
    var split:List <String> = input.split(",")

    println(split.size)
    name = split[0]
    age =  split[1].toInt()
    wage = split[2].toDouble()

     println("name = $name")
    println("age = $age")
    println("wage = $wage")

}