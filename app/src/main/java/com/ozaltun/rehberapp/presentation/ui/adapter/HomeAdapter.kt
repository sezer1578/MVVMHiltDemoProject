package com.ozaltun.rehberapp.presentation.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ozaltun.rehberapp.R
import com.ozaltun.rehberapp.data.model.Person
import com.ozaltun.rehberapp.databinding.RowItemBinding
import com.ozaltun.rehberapp.presentation.ui.fragment.HomeFragmentDirections
import com.ozaltun.rehberapp.presentation.ui.util.go
import com.ozaltun.rehberapp.presentation.ui.viewmodel.HomeFragmentViewModel

class HomeAdapter(
    val context: Context,
    var personList: List<Person>,
    val viewModel: HomeFragmentViewModel
) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: RowItemBinding

        init {
            this.binding = binding
        }
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val person = personList.get(position)
        val tempBinding = holder.binding

        tempBinding.data = person
        tempBinding.textViewCard.setOnClickListener {
            val nav = HomeFragmentDirections.actionHomeFragmentToDetailFragment(person)
            Navigation.go(it, nav)
        }
        tempBinding.imageView.setOnClickListener {
            Snackbar.make(it, "${person.personName} silinsin mi ?", Snackbar.LENGTH_LONG)
                .setAction("EVET") {
                    viewModel.deletePerson(person.personId)
                }.show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: RowItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.row_item, parent, false)
        return HomeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return personList.size
    }
}