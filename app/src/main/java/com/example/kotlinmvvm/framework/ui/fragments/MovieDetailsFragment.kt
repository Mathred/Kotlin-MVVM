package com.example.kotlinmvvm.framework.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmvvm.databinding.MovieDetailsFragmentBinding
import com.example.kotlinmvvm.framework.ui.recyclerviews.moviedetailsfragmentrecyclerview.CastRecyclerViewAdapter
import com.example.kotlinmvvm.framework.viewmodels.MovieDetailsViewModel
import com.example.kotlinmvvm.model.AppState
import com.example.kotlinmvvm.model.entities.Actor
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailsFragment : Fragment() {

    private lateinit var binding: MovieDetailsFragmentBinding
    private val viewModel: MovieDetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MovieDetailsFragmentBinding.inflate(inflater, container, false)
        with(binding) {
            val moviePosterIV = movieDetailsMoviePosterIV
            val movieTitleTV = movieDetailsMovieNameTV
            val movieYearReleasedTV = movieDetailsMovieYearReleasedTV
            val movieGenreTV = movieDetailsMovieGenreTV
            val movieLengthTV = movieDetailsMovieLengthTV
            val movieAnnotationTV = movieDetailsMovieAnnotationTV
            val castRV = movieDetailsMovieCastRV

            castRV.layoutManager = LinearLayoutManager(root.context, LinearLayoutManager.HORIZONTAL, false)
            castRV.setHasFixedSize(true)
            castRV.adapter = CastRecyclerViewAdapter(listOf(Actor()), root.context)
        }
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
        fun newInstance() = MovieDetailsFragment()
    }

}