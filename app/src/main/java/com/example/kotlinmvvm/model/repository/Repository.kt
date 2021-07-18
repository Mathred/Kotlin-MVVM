package com.example.kotlinmvvm.model.repository

import com.example.kotlinmvvm.model.entities.ActorList
import com.example.kotlinmvvm.model.entities.MovieCategory
import com.example.kotlinmvvm.model.entities.Movie
import com.example.kotlinmvvm.model.entities.TV

interface Repository {
    fun getMovieFromServer(id: Int?): Movie
    fun getMovieFromLocalStorage(id: Int?): Movie
    fun getMovieListFromServer(id: Int?): MovieCategory
    fun getMovieListFromLocalStorage(id: Int?): MovieCategory
    fun getActorListFromServer(id: Int?): ActorList
    fun getActorListFromLocalStorage(id: Int?): ActorList
    fun getDefaultCategoriesList(): List<MovieCategory>

    fun getTrendingMoviesListToday(): MovieCategory
    fun getTrendingMoviesListWeek(): List<Movie>

    fun getTrendingTVListToday(): List<TV>
    fun getTrendingTVListWeek(): List<TV>

    fun getNowPlayingMoviesList(): List<Movie>

    fun getPopularMoviesList(): List<Movie>

    fun getTopRatedMoviesList(): List<Movie>

    fun getUpcomingMoviesList(): List<Movie>

}