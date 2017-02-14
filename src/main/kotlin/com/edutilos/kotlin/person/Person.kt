package com.edutilos.kotlin.person


class Person(Id:Long , Name:String, Age:Int , Wage:Double , Active:Boolean) {
   var id = Id
    var name = Name
   var age = Age
    var wage = Wage
    var active = Active

    constructor():this(0, "foo", 0 , 0.0 , false) {
    }

   override fun toString():String {
       return "$id , $name , $age, $wage, $active"
   }
}