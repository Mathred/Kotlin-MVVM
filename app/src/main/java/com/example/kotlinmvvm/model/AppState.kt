package com.example.kotlinmvvm.model

import com.example.kotlinmvvm.model.entities.Movie

sealed class AppState {
    data class Success(val data: Movie) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}