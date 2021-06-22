package com.example.kotlinmvvm.model.repository

import com.example.kotlinmvvm.model.entities.ActorList
import com.example.kotlinmvvm.model.entities.MovieCategory
import com.example.kotlinmvvm.model.entities.Movie

class RepositoryImpl : Repository {

    val defaultCategoryList = listOf<MovieCategory>()



    override fun getMovieFromServer(id: Int?): Movie {
        return Movie()
    }

    override fun getMovieFromLocalStorage(id: Int?): Movie {
        return Movie()
    }

    override fun getMovieListFromServer(id: Int?): MovieCategory {
        return MovieCategory()
    }

    override fun getMovieListFromLocalStorage(id: Int?): MovieCategory {
        return MovieCategory()
    }

    override fun getActorListFromServer(id: Int?): ActorList {
        return ActorList()
    }

    override fun getActorListFromLocalStorage(id: Int?): ActorList {
        return ActorList()
    }

    override fun getDefaultCategoriesList(): List<MovieCategory> {
        return listOf(
            MovieCategory(0, "default1"),
        MovieCategory(0, "default2"),
        MovieCategory(0, "default3"),
        MovieCategory(0, "default4")
        )
    }
}