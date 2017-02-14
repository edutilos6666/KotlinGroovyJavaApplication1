package com.edutilos.kotlin.person

import java.util.*

class PersonDAOInMemoryImpl:PersonDAO {
    private var container:HashMap<Long , Person> = HashMap<Long, Person>()
    override fun save(p: Person) {
        container.put(p.id , p)
    }

    override fun update(id: Long, p: Person) {
        container.put(id, p)
    }

    override fun delete(id: Long) {
        container.remove(id)
    }

    override fun findById(id: Long): Person {
        return container.get(id) as Person
    }

    override fun findAll(): List<Person> {
         val values =  container.values
        val list = ArrayList<Person>()
        values.forEach { el -> list.add(el) }
        return list
    }

    override  fun deleteAll()  {
          container = HashMap<Long, Person>()
    }
}