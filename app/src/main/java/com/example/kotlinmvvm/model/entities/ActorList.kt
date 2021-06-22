package com.example.kotlinmvvm.model.entities

data class ActorList(
    val actorListId: Int = 0,
    val actorList: List<Actor> = listOf(
        Actor(),
        Actor(),
        Actor(),
        Actor(),
        Actor(),
        Actor(),
        Actor(),
        Actor(),
        Actor(),
        Actor(),
        Actor()
    )
)
