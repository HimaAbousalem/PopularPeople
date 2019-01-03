package com.example.abousalem.movieapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Actor(
    @SerializedName("id")
    val id: Long,
    @SerializedName("popularity")
    val actorPopularity: Double,
    @SerializedName("profile_path")
    var actorProfilePic: String,
    @SerializedName("name")
    val actorName: String,
    @SerializedName("known_for")
    val knownFor: ArrayList<Movie>
) : Parcelable{
    constructor():this(0,0.0,"","",ArrayList<Movie>())
}