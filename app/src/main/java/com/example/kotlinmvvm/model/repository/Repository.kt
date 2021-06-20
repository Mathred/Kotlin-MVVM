package com.example.kotlinmvvm.model.repository

import com.example.kotlinmvvm.model.entities.ActorList
import com.example.kotlinmvvm.model.entities.Category
import com.example.kotlinmvvm.model.entities.Movie

interface Repository {
    fun getMovieFromServer(id: Int?): Movie
    fun getMovieFromLocalStorage(id: Int?): Movie
    fun getMovieListFromServer(id: Int?): Category
    fun getMovieListFromLocalStorage(id: Int?): Category
    fun getActorListFromServer(id: Int?): ActorList
    fun getActorListFromLocalStorage(id: Int?): ActorList
}