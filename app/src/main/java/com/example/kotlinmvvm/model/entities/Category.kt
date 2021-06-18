package com.example.kotlinmvvm.model.entities

data class Category(
    val category: String = "Default",
    val movieList: List<Movie> = listOf(
        Movie("Die Hard", 77,null,1988),
        Movie("Die Hard 2", 69, null, 1990),
        Movie("Die Hard 3", 72, null, 1995),
    )
)
