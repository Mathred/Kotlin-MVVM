package com.example.kotlinmvvm.model.appstates

import com.example.kotlinmvvm.model.entities.Movie

sealed class MovieDetailsAppState {
    data class Success(val data: Movie) : MovieDetailsAppState()
    data class Error(val error: Throwable) : MovieDetailsAppState()
    object Loading : MovieDetailsAppState()
}