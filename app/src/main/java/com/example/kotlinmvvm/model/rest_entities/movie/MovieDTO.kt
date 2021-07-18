package com.example.kotlinmvvm.model.rest_entities.movie

import java.util.*

data class MovieDTO(
    val id : Int?,
    val genres: Array<GenreDTO>?,
    val original_title: String?,
    val overview: String?,
    val poster_path: String?,
    val production_countries: Array<ProductionCountryDTO>?,
    val release_date: Date?,
    val runtime: Int?,
    val status: String?,
    val title: String?,
    val vote_average: Double?,
    val vote_count: Int?
)
