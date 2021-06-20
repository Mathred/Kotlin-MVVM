package com.example.kotlinmvvm.framework.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmvvm.databinding.MainFragmentBinding
import com.example.kotlinmvvm.framework.viewmodels.MainFragmentViewModel
import com.example.kotlinmvvm.framework.ui.recyclerviews.mainfragmentrecyclerview.ParentRecyclerViewAdapter
import com.example.kotlinmvvm.model.AppState
import com.example.kotlinmvvm.model.entities.Category
import com.example.kotlinmvvm.model.entities.Movie
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding
    private val fragmentViewModel: MainFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        binding.mainFragmentParentRecyclerView.layoutManager = LinearLayoutManager(binding.root.context,LinearLayoutManager.VERTICAL,false)
        binding.mainFragmentParentRecyclerView.setHasFixedSize(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycle.addObserver(fragmentViewModel)

        val observer = Observer<AppState> { renderData(it) }
        fragmentViewModel.getLiveData().observe(viewLifecycleOwner, observer)

        fragmentViewModel.getData()
    }

    private fun renderData(appState: AppState) = with(binding){
        when (appState) {
            is AppState.Success -> {
                binding.mainFragmentParentRecyclerView.adapter = ParentRecyclerViewAdapter(listOf(Category(), Category(), Category()),binding.root.context)
            }
            is AppState.Loading -> {

            }
            is AppState.Error -> {
                Snackbar
                    .make(mainFragment, "Error", Snackbar.LENGTH_SHORT)
                    .setAction("Reload") {fragmentViewModel.getData()}
                    .show()
            }
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }

}