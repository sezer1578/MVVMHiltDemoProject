package com.ozaltun.rehberapp.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ozaltun.rehberapp.R
import com.ozaltun.rehberapp.databinding.FragmentDetailBinding
import com.ozaltun.rehberapp.presentation.ui.viewmodel.DetailFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_detail, container, false)

        binding.detailFragment = this
        binding.toolBarBaslikDetail = "Kisi Detay"

        val bundle: DetailFragmentArgs by navArgs()
        val getData = bundle.person
        binding.person = getData

        return binding.root
    }

    fun btnUpdate(personId: Int, personName: String, personNumber: String) {
        viewModel.updateUser(personId, personName, personNumber)
    }

}