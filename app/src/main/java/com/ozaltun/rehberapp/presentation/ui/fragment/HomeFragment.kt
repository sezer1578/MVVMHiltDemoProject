package com.ozaltun.rehberapp.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ozaltun.rehberapp.R
import com.ozaltun.rehberapp.data.model.Person
import com.ozaltun.rehberapp.databinding.FragmentHomeBinding
import com.ozaltun.rehberapp.presentation.ui.adapter.HomeAdapter
import com.ozaltun.rehberapp.presentation.ui.util.go
import com.ozaltun.rehberapp.presentation.ui.viewmodel.HomeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: HomeAdapter
    private val viewModel: HomeFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)

        binding.homeFragment = this

        binding.toolBarTitleHome = "Kisiler Ana Sayfa"
        (activity as AppCompatActivity).setSupportActionBar(binding.homeMaterialToolbar)

        viewModel.personList.observe(viewLifecycleOwner) {
            adapter = HomeAdapter(requireContext(), it, viewModel)
            binding.adapter = adapter
        }



        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.search_menu, menu)

                val item = menu.findItem(R.id.menuSearch)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@HomeFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return binding.root
    }

    fun fabOnclick(it: View) {
        Navigation.go(it, R.id.action_homeFragment_to_addFragment)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.searchPerson(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.searchPerson(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllPersons()
    }


}