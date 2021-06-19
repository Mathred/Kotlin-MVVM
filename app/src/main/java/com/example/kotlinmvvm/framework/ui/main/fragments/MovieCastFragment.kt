package com.example.kotlinmvvm.framework.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmvvm.databinding.MovieCastFragmentBinding
import com.example.kotlinmvvm.framework.ui.main.recyclerviews.MovieCastFragmentRecycleViewAdapter
import com.example.kotlinmvvm.framework.viewmodels.MovieCastViewModel
import com.example.kotlinmvvm.model.AppState
import com.example.kotlinmvvm.model.entities.Actor
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieCastFragment : Fragment() {

    private lateinit var binding: MovieCastFragmentBinding
    private val viewModel: MovieCastViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MovieCastFragmentBinding.inflate(inflater, container, false)
        val movieCastRV = binding.castFragmentRV
        movieCastRV.layoutManager =
            LinearLayoutManager(binding.root.context, LinearLayoutManager.VERTICAL, false)
        movieCastRV.setHasFixedSize(true)
        movieCastRV.adapter = MovieCastFragmentRecycleViewAdapter(listOf(Actor()), binding.root.context)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(viewModel)

        val observer = Observer<AppState> {renderData(it)}
        viewModel.getLiveData().observe(viewLifecycleOwner, observer)
        viewModel.getData()
    }

    private fun renderData(appState: AppState?) {
        TODO("Not yet implemented")
    }

    companion object {
        fun newInstance() = MovieCastFragment()
    }
}