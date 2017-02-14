package com.edutilos.kotlin.person

fun main(args: Array<String>) {
    var p = Person(1 , "foo", 10 , 100.0 , true)
    println(p.name)
    println(p.id)
    println(p.age)
    println(p.wage)
    println(p.active)
}