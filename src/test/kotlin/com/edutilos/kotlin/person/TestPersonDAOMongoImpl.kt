package com.edutilos.kotlin.person

import junit.framework.TestCase
import org.junit.Assert.*

class TestPersonDAOMongoImpl:TestCase() {
  private var dao:PersonDAO = PersonDAOMongoImpl()

    private fun insert() {
        dao.save(Person(1, "foo", 10, 100.0 , true))
        dao.save(Person(2, "bar", 20 , 200.0 , false))

    }

    private fun clean() {
        dao.deleteAll()
    }


    fun testSave() {
        insert()
        val list = dao.findAll()
       assertEquals(2, list.size)
        var  p:Person = list[0]
        assertEquals(1, p.id)
        assertEquals("foo", p.name)
        assertEquals(10, p.age)
        assertEquals(100.0 , p.wage, 100.0)
        assertEquals(true, p.active)
        clean()
    }

    fun testUpdate() {
        insert()
         dao.update(2, Person(2, "newbar", 66, 666.6 , true))
          var p = dao.findById(2)
        assertEquals(2, p.id)
        assertEquals("newbar", p.name)
        assertEquals(66, p.age)
        assertEquals(666.6, p.wage)
        assertEquals(true, p.active)
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