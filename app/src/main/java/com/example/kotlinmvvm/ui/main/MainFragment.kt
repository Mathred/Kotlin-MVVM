package com.example.kotlinmvvm.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.kotlinmvvm.databinding.MainFragmentBinding
import com.example.kotlinmvvm.model.AppState
import com.example.kotlinmvvm.model.entities.Movie
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

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
                    .make(main, "Error", Snackbar.LENGTH_SHORT)
                    .setAction("Reload") {viewModel.getData()}
                    .show()
            }
        }
    }

    private fun setData(movie: Movie) = with(binding) {
        //TODO "Implement UI update"
    }

}