package com.example.abousalem.movieapp.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("vote_count")
    val voteCount: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("video")
    val video: String,
    @SerializedName("title")
    val movieTitle: String,
    @SerializedName("vote_average")
    val voteAverage: String,
    @SerializedName("popularity")
    val moviePopularity: String,
    @SerializedName("poster_path")
    val moviePoster: String,
    @SerializedName("original_language")
    val movieOriginalLanguage: String,
    @SerializedName("original_title")
    val movieOriginalTitle: String,
    @SerializedName("backdrop_path")
    val movieBackdropPath: String,
    @SerializedName("adult")
    val adult: String,
    @SerializedName("overview")
    val movieOverview: String,
    @SerializedName("release_date")
    val movieReleaseDate: String
) : Parcelable {
    constructor(): this("","","","","",
        "","","","",
        "","","","")
}

