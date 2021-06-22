package com.example.kotlinmvvm.model.repository

import com.example.kotlinmvvm.model.entities.ActorList
import com.example.kotlinmvvm.model.entities.MovieCategory
import com.example.kotlinmvvm.model.entities.Movie

interface Repository {
    fun getMovieFromServer(id: Int?): Movie
    fun getMovieFromLocalStorage(id: Int?): Movie
    fun getMovieListFromServer(id: Int?): MovieCategory
    fun getMovieListFromLocalStorage(id: Int?): MovieCategory
    fun getActorListFromServer(id: Int?): ActorList
    fun getActorListFromLocalStorage(id: Int?): ActorList
    fun getDefaultCategoriesList(): List<MovieCategory>

}