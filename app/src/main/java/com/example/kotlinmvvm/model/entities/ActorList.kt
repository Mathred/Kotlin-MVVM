package com.example.kotlinmvvm.model.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ActorList(
    val actorListId: Int = 0,
    val cast: List<Actor>? = null
) : Parcelable {
    companion object {
        fun getDefaultActorList() : ActorList {
            return ActorList(0, listOf(Actor(),
                Actor(),
                Actor(),
                Actor(),
                Actor(),
                Actor(),
                Actor(),
                Actor(),
                Actor(),
                Actor(),
                Actor()))
        }
    }
}
