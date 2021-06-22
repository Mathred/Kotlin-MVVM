package com.example.kotlinmvvm.model.entities

data class Movie(
    val id: Int = 0,
    val name: String = "Die hard",
    val rating: Int = 77,
    val poster: Int? = null,
    val yearReleased: Int = 1988,
    val cast: List<Actor>? = null,
    val action: (() -> Unit)? = null
)
