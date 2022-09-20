package com.ozaltun.rehberapp.data.repository


import androidx.lifecycle.MutableLiveData
import com.ozaltun.rehberapp.data.model.Person
import com.ozaltun.rehberapp.domain.room.dao.PersonDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonRepository(var personDao: PersonDao) {

    private var personList: MutableLiveData<List<Person>> = MutableLiveData()

    init {
        getPersons()
    }

    fun delete(personId: Int) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val deletePerson = Person(personId, "", "")
            personDao.deletePerson(deletePerson)
            getPersons()
        }
    }

    fun search(word: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            personList.value = personDao.searchPerson(word)
        }
    }

    fun getPerson(): MutableLiveData<List<Person>> {
        return personList
    }

    fun add(personName: String, personNumber: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val tempPerson = Person(0, personName, personNumber)
            personDao.insertPerson(tempPerson)
        }
    }

    fun update(personId: Int, personName: String, personNumber: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val tempPerson = Person(personId, personName, personNumber)
            personDao.insertPerson(tempPerson)
        }
    }

    fun getPersons() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            personList.value = personDao.getAllPersons()
        }

    }
}