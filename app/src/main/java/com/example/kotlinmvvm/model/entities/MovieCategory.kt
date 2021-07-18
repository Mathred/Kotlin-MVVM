package com.example.kotlinmvvm.model.entities

data class MovieCategory(
    val categoryTitle: String = "Default",
    val movieList: MutableList<Movie> = mutableListOf(
        Movie(),
        Movie(),
        Movie(),
        Movie(),
        Movie(),
        Movie(),
    )
) {
    companion object {
        fun getDefaultMovieCategoriesList(): List<MovieCategory> {

            return listOf(
                MovieCategory("default1"),
                MovieCategory("default2"),
                MovieCategory("default3"),
                MovieCategory("default4")
            )
        }
    }
}
