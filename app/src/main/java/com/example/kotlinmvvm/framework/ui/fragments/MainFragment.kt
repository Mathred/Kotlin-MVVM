package com.example.kotlinmvvm.framework.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmvvm.databinding.MainFragmentBinding
import com.example.kotlinmvvm.framework.ui.recyclerviews.mainfragmentrecyclerview.ParentRecyclerViewAdapter
import com.example.kotlinmvvm.framework.viewmodels.MainFragmentViewModel
import com.example.kotlinmvvm.model.appstates.MainFragmentAppState
import com.example.kotlinmvvm.model.entities.MovieCategory
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding
    private lateinit var adapter: ParentRecyclerViewAdapter
    private val fragmentViewModel: MainFragmentViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        binding.mainFragmentParentRecyclerView.layoutManager =
            LinearLayoutManager(binding.root.context, LinearLayoutManager.VERTICAL, false)
        binding.mainFragmentParentRecyclerView.setHasFixedSize(true)
        adapter = ParentRecyclerViewAdapter(MovieCategory.getDefaultMovieCategoriesList(),binding.root.context)
        binding.mainFragmentParentRecyclerView.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycle.addObserver(fragmentViewModel)

        val observer = Observer<MainFragmentAppState> { renderData(it) }
        fragmentViewModel.getLiveData().observe(viewLifecycleOwner, observer)

        fragmentViewModel.getData()
    }

    private fun renderData(mainFragmentAppState: MainFragmentAppState) = with(binding) {
        when (mainFragmentAppState) {
            is MainFragmentAppState.Success -> {

                adapter.setItems(mainFragmentAppState.data.map { it.toMovieViewModel() })

            }
            is MainFragmentAppState.Loading -> {

            }
            is MainFragmentAppState.Error -> {
                Snackbar
                    .make(mainFragment, "Error", Snackbar.LENGTH_SHORT)
                    .setAction("Reload") { fragmentViewModel.getData() }
                    .show()
            }
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }

}


