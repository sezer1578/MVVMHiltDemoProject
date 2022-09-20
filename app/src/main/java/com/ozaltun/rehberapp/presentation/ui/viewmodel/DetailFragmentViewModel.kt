package com.ozaltun.rehberapp.presentation.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ozaltun.rehberapp.data.repository.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailFragmentViewModel @Inject constructor(private val repo : PersonRepository) : ViewModel() {

    fun updateUser(personId: Int, personName: String, personNumber: String) {
        repo.update(personId, personName, personNumber)
    }
}