package com.edutilos.kotlin.main

import java.util.*

object Example1 {
    @JvmStatic
    fun main(args: Array<String>) {
        println("hello world")

        var simpleMath = SimpleMath()
        var x1:Double  = 10.0
        var x2:Double =  5.0

        var sum = simpleMath.add(x1, x2)
        var sub = simpleMath.sub(x1, x2)
        var mult = simpleMath.mult(x1, x2)
        var div = simpleMath.div(x1, x2)

        println("$x1 + $x2 = $sum")
        println("$x1 * $x2 = $mult")
        println("$x1 - $x2 = $sub")
        println("$x1 / $x2 = $div")


        var list:ArrayList<String> = ArrayList<String>()
        list.add("foo")
        list.add("bar")
        list.add("bim")
        list.forEach { el ->  println(el) }



    }
}