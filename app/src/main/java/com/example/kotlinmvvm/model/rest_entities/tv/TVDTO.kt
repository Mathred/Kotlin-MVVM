package com.example.kotlinmvvm.model.rest_entities.tv

import com.example.kotlinmvvm.model.rest_entities.movie.GenreDTO
import com.example.kotlinmvvm.model.rest_entities.movie.ProductionCountryDTO
import java.util.*

data class TVDTO(
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
