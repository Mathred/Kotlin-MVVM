package com.example.kotlinmvvm.model.repository

import com.example.kotlinmvvm.model.entities.ActorList
import com.example.kotlinmvvm.model.entities.Category
import com.example.kotlinmvvm.model.entities.Movie

class RepositoryImpl : Repository {

    override fun getMovieFromServer(id: Int?): Movie {
        return Movie()
    }

    override fun getMovieFromLocalStorage(id: Int?): Movie {
        return Movie()
    }

    override fun getMovieListFromServer(id: Int?): Category {
        return Category()
    }

    override fun getMovieListFromLocalStorage(id: Int?): Category {
        return Category()
    }

    override fun getActorListFromServer(id: Int?): ActorList {
        return ActorList()
    }

    override fun getActorListFromLocalStorage(id: Int?): ActorList {
        return ActorList()
    }
}