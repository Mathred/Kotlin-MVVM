package com.example.kotlinmvvm.framework.ui.main.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinmvvm.R
import com.example.kotlinmvvm.databinding.MovieCastFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieCastFragment : Fragment() {

    private lateinit var binding: MovieCastFragmentBinding
    private val viewModel: MovieCastViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MovieCastFragmentBinding.inflate(inflater, container, false)
        with(binding) {

        }


        return inflater.inflate(R.layout.movie_cast_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MovieCastViewModel::class.java)
        // TODO: Use the ViewModel
    }

    companion object {
        fun newInstance() = MovieCastFragment()
    }
}