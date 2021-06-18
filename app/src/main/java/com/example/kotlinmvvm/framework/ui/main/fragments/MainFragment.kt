package com.example.kotlinmvvm.framework.ui.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmvvm.databinding.MainFragmentBinding
import com.example.kotlinmvvm.framework.viewmodels.MainViewModel
import com.example.kotlinmvvm.framework.ui.main.recyclerviews.mainfragmentrecyclerview.ParentRecyclerViewAdapter
import com.example.kotlinmvvm.model.AppState
import com.example.kotlinmvvm.model.entities.Category
import com.example.kotlinmvvm.model.entities.Movie
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        binding.mainFragmentParentRecyclerView.layoutManager = LinearLayoutManager(binding.root.context,LinearLayoutManager.VERTICAL,false)
        binding.mainFragmentParentRecyclerView.setHasFixedSize(true)
        binding.mainFragmentParentRecyclerView.adapter = ParentRecyclerViewAdapter(listOf(Category()),binding.root.context)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycle.addObserver(viewModel)

        val observer = Observer<AppState> { renderData(it) }
        viewModel.getLiveData().observe(viewLifecycleOwner, observer)

        viewModel.getData()
    }

    private fun renderData(appState: AppState) = with(binding){
        when (appState) {
            is AppState.Success -> {
                setData(appState.data)
            }
            is AppState.Loading -> {

            }
            is AppState.Error -> {
                Snackbar
                    .make(mainFragment, "Error", Snackbar.LENGTH_SHORT)
                    .setAction("Reload") {viewModel.getData()}
                    .show()
            }
        }
    }

    private fun setData(movie: Movie) = with(binding) {
    }

    companion object {
        fun newInstance() = MainFragment()
    }

}