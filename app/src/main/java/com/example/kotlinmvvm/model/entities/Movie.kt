package com.example.kotlinmvvm.model.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.Duration

@Parcelize
data class Movie(
    val id: Int? = 0,
    val title: String? = "Die hard",
    val genre: String? = "Action",
    val duration: Duration? = null,
    val annotation: String? = "Cool action movie",
    val voteAverage: Double? = 7.7,
    val poster: Int? = null,
    val yearReleased: Int = 1988,
    val cast: ActorList? = null,
    val action: (() -> Unit)? = null
) : Parcelable {

}
