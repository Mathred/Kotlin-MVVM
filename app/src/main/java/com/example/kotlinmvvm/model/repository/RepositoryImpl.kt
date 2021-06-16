package com.example.kotlinmvvm.model.repository

import com.example.kotlinmvvm.model.entities.Movie

class RepositoryImpl : Repository {
    override fun getDataFromServer(): Movie {
        return Movie()
    }

    override fun getDataFromLocalStorage(): Movie {
        return Movie()
    }
}