package com.example.kotlinmvvm.model.appstates

import com.example.kotlinmvvm.model.entities.MovieCategory


sealed class MainFragmentAppState {
    data class Success(val data: List<MovieCategory>) : MainFragmentAppState()
    data class Error(val error: Throwable) : MainFragmentAppState()
    object Loading : MainFragmentAppState()

}