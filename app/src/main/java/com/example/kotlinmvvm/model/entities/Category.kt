package com.example.kotlinmvvm.model.entities

data class Category(
    val id: Int = 0,
    val category: String = "Default",
    val movieList: List<Movie> = listOf(
        Movie(0,"Die Hard", 77,null,1988, null),
        Movie(0,"Die Hard", 77,null,1988, null),
        Movie(0,"Die Hard 2", 69, null, 1990, null),
        Movie(0,"Die Hard 3", 72, null, 1995, null),
        Movie(0,"Die Hard 2", 69, null, 1990, null),
        Movie(0,"Die Hard 3", 72, null, 1995, null),
        Movie(0,"Die Hard", 77,null,1988, null),
        Movie(0,"Die Hard 2", 69, null, 1990, null),
        Movie(0,"Die Hard 3", 72, null, 1995, null),
        Movie(0,"Die Hard", 77,null,1988, null),
        Movie(0,"Die Hard 2", 69, null, 1990, null),
        Movie(0,"Die Hard 3", 72, null, 1995, null),
    )
)
