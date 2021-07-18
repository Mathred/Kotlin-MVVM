package com.example.kotlinmvvm.model.rest_entities.trending_list

import com.example.kotlinmvvm.model.rest_entities.movie.MovieDTO

data class TrendingMovieListDTO (
    val page: Int?,
    val results: Array<MovieDTO>?
): TrendingLists
