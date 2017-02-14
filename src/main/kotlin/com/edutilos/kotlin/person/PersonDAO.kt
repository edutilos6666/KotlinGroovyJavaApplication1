package com.edutilos.kotlin.person

interface PersonDAO {
  public fun save(p:Person):Unit
    public fun update(id:Long , p:Person):Unit
    public fun delete(id:Long)
    public fun findById(id:Long):Person
    public fun findAll():List<Person>
    public fun deleteAll(): Unit
}