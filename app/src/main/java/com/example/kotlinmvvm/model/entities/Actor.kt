package com.example.kotlinmvvm.model.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Actor(
    val id: Int = 0,
    val firstName: String? = "Ivan",
    val lastName: String? = "Ivanov",
    val photo: Int? = 1,
    val role: String = "Petr Petrov"
) : Parcelable

