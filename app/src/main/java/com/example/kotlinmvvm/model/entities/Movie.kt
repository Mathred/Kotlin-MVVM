package com.example.kotlinmvvm.model.entities

data class Movie(
    val name: String = "Die hard",
    val rating: Int = 77,
    val poster: Int?,
    val yearReleased: Int = 1988,
    val cast: List<Actor>?
) {
    companion object {
        fun getDefaultMovie() = Movie("Die Hard", 77,null,1988, null)
    }
}
