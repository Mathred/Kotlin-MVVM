package com.example.kotlinmvvm.framework.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmvvm.databinding.MovieDetailsFragmentBinding
import com.example.kotlinmvvm.framework.ui.recyclerviews.decorations.HorizontalListDividerItemDecorator
import com.example.kotlinmvvm.framework.ui.recyclerviews.moviedetailsfragmentrecyclerview.CastRecyclerViewAdapter
import com.example.kotlinmvvm.framework.viewmodels.MovieDetailsViewModel
import com.example.kotlinmvvm.model.appstates.MainFragmentAppState
import com.example.kotlinmvvm.model.entities.Actor
import com.example.kotlinmvvm.model.entities.ActorList
import com.example.kotlinmvvm.model.entities.Movie
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailsFragment : Fragment() {

    private lateinit var binding: MovieDetailsFragmentBinding
    private lateinit var adapter: CastRecyclerViewAdapter
    private val viewModel: MovieDetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MovieDetailsFragmentBinding.inflate(inflater, container, false)
        with(binding) {
            val castRV = movieDetailsMovieCastRV
            castRV.layoutManager = LinearLayoutManager(root.context, LinearLayoutManager.HORIZONTAL, false)
            castRV.setHasFixedSize(true)
            adapter = CastRecyclerViewAdapter(null,root.context)
            castRV.adapter = CastRecyclerViewAdapter(null, root.context)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        arguments?.getParcelable<Movie>(BUNDLE_EXTRA)?.let {
            val movie = it
//            binding.movieDetailsMoviePosterIV.setImageDrawable(movie.poster) TODO("Implement drawings")
            binding.movieDetailsMovieTitleTV.text = movie.title
            binding.movieDetailsMovieYearReleasedTV.text = movie.yearReleased.toString()
            binding.movieDetailsMovieGenreTV.text = movie.genre
            binding.movieDetailsMovieDurationTV.text = movie.duration.toString()
            binding.movieDetailsMovieAnnotationTV.text = movie.annotation
            adapter.setItems(movie.cast)
            binding.movieDetailsMovieCastRV.addItemDecoration(HorizontalListDividerItemDecorator(8))
        }
    }

    private fun renderData(mainFragmentAppState: MainFragmentAppState?) {
        TODO("Not yet implemented")
    }

    companion object {
        const val BUNDLE_EXTRA = "movie"

        fun newInstance(bundle: Bundle) : MovieDetailsFragment {
            val fragment = MovieDetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

}