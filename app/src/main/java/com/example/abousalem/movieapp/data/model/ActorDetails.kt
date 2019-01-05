package com.example.abousalem.movieapp.data.model

import com.google.gson.annotations.SerializedName

data class ActorDetails(
    val birthday: String,
    @SerializedName("known_for_department")
    val knownForDepartment: String,
    @SerializedName("deathday")
    val deathDay: String,
    val id: Long,
    @SerializedName("place_of_birth")
    val placeOfBirth: String,
    val popularity: Double,
    @SerializedName("profile_path")
    val profilePic: String,
    val name: String
)