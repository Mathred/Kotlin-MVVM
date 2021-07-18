package com.example.kotlinmvvm.model.rest_entities.trending_list

import com.example.kotlinmvvm.model.rest_entities.movie.MovieDTO
import com.example.kotlinmvvm.model.rest_entities.tv.TVDTO

data class TrendingTVListDTO(
    val page: Int?,
    val results: Array<TVDTO>?
) : TrendingLists
