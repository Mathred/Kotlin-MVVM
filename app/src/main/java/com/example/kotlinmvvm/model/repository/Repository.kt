package com.example.kotlinmvvm.model.repository

import com.example.kotlinmvvm.model.entities.Movie

interface Repository {
    fun getDataFromServer(): Movie
    fun getDataFromLocalStorage(): Movie
}