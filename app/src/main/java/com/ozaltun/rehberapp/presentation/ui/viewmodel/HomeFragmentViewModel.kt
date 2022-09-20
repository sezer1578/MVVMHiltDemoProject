package com.ozaltun.rehberapp.presentation.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ozaltun.rehberapp.data.model.Person
import com.ozaltun.rehberapp.data.repository.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel  @Inject constructor(private val repo : PersonRepository): ViewModel() {

    var personList: MutableLiveData<List<Person>> = MutableLiveData()

    init {
        getAllPersons()
        personList = repo.getPerson()
    }

    fun getAllPersons() {
        repo.getPersons()
    }

    fun searchPerson(word: String) {
        repo.search(word)
    }

    fun deletePerson(personId: Int) {
        repo.delete(personId)
    }
}