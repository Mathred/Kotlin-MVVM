package com.example.kotlinmvvm.model.entities

data class MovieCategory(
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
) {
    fun toMovieViewModel() {
        TODO("Not yet implemented")
    }

    companion object {
        fun getDefaultMovieCategoriesList(): List<MovieCategory> {
            return listOf(
                MovieCategory(0, "default1"),
                MovieCategory(0, "default2"),
                MovieCategory(0, "default3"),
                MovieCategory(0, "default4"))
        }
    }
}
