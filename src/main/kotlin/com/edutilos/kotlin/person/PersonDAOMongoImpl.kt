package com.edutilos.kotlin.person

import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import org.bson.Document
import java.util.*


class PersonDAOMongoImpl():PersonDAO {
    //properties
    private val host:String = "localhost"
    private val port:Int = 27017

    //variables
        private var client: MongoClient = MongoClient(host, port)
        private var db:MongoDatabase = client.getDatabase("test2")
       private var collPerson:MongoCollection<Document> = db.getCollection("person")


    private fun connect() {
        client = MongoClient(host, port)
        db= client.getDatabase("test2")
        collPerson= db.getCollection("person")

    }

    private fun disconnect() {
        client.close()
    }
    override fun save(p: Person) {
        connect()
        val doc:Document = Document("id", p.id)
        .append("name", p.name)
        .append("age", p.age)
        .append("wage", p.wage)
        .append("active", p.active)
        collPerson.insertOne(doc)
        disconnect()
    }

    override fun update(id: Long, p: Person) {
        connect()
        val newDoc:Document = Document("id", id)
        .append("name", p.name)
        .append("age", p.age)
        .append("wage", p.wage)
        .append("active", p.active)
        collPerson.replaceOne(Filters.eq("id", id), newDoc)
        disconnect()
    }

    override fun delete(id: Long) {
        connect()
        collPerson.deleteOne(Filters.eq("id", id))
        disconnect()
    }

    override fun findById(id: Long): Person {
        connect()
        var p:Person
        var cursor = collPerson.find(Filters.eq("id", id)).iterator()
        var doc = cursor.next()
         p = docToPerson(doc)
        disconnect()
        return p
    }

    private fun docToPerson(doc:Document): Person {
        return Person(doc.getLong("id"), doc.getString("name"), doc.getInteger("age"),
                doc.getDouble("wage"), doc.getBoolean("active"))
    }

    override fun findAll(): List<Person> {
        connect()
        val list = ArrayList<Person>()
        var cursor = collPerson.find().iterator()
        while(cursor.hasNext()) {
            var doc = cursor.next()
            list.add(docToPerson(doc))
        }
        disconnect()
        return list
    }

    override fun deleteAll() {
        connect()
        collPerson.drop()
        disconnect()
    }
}