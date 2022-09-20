package com.ozaltun.rehberapp.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.ozaltun.rehberapp.R
import com.ozaltun.rehberapp.databinding.FragmentAddBinding
import com.ozaltun.rehberapp.presentation.ui.viewmodel.AddFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private val viewModel: AddFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_add, container, false)

        binding.addFragment = this
        binding.toolbarTitle = "Kisi Kayit"
        return binding.root
    }

    fun btnAddNewUser(personName: String, personNumber: String) {
        viewModel.addNewUser(personName, personNumber)
    }

}