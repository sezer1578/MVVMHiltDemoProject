package com.ozaltun.rehberapp.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.ozaltun.rehberapp.data.repository.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddFragmentViewModel @Inject constructor(private val repo: PersonRepository) : ViewModel() {

    fun addNewUser(personName: String, personNumber: String) {
        repo.add(personName, personNumber)
    }
}