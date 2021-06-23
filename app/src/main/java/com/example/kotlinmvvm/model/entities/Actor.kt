package com.example.kotlinmvvm.model.entities

data class Actor(
    val id: Int = 0,
    val firstName: String? = "Ivan",
    val lastName: String? = "Ivanov",
    val photo: Int? = 1,
    val role: String = "Petr Petrov"
)

