package com.edutilos.kotlin.person

import junit.framework.TestCase
import org.junit.Assert.*

class TestPersonDAOInMemoryImpl():TestCase() {

    private val dao:PersonDAO = PersonDAOInMemoryImpl()

    private fun insert() {
       dao.save(Person(1, "foo", 10, 100.0 , true))
        dao.save(Person(2, "bar", 20, 200.0 , false))
    }


    private fun clean() {
        dao.deleteAll()
    }

    fun testSave() {
     insert()
      val list = dao.findAll()
        assertEquals(2, list.size)
        var p1 = list[0]
        assertEquals(1, p1.id)
        assertEquals("foo", p1.name)
        assertEquals(10, p1.age)
        assertEquals(100.0 , p1.wage, 0.0)
        assertEquals(true , p1.active)
      clean()
    }

    fun testUpdate() {
       insert()
        dao.update(1, Person(1, "newfoo", 66, 666.6, false))
        var p1 = dao.findById(1)
        assertEquals(1, p1.id)
        assertEquals("newfoo",p1.name )
        assertEquals(66, p1.age)
        assertEquals(666.6, p1.wage)
        assertEquals(false, p1.active)
        clean()
    }

    fun testDelete() {
      insert()
        var list = dao.findAll()
        assertEquals(2, list.size)
        dao.delete(1)
        list = dao.findAll()
        assertEquals(1, list.size)
        dao.delete(2)
        list = dao.findAll()
        assertEquals(0, list.size)
        clean()
    }
}