package com.example.abousalem.movieapp.data.model

import com.google.gson.annotations.SerializedName


data class ActorPicture(
    @SerializedName("iso_639_1")
    val iso_639_1: String,
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("vote_count")
    val vote_count: Int,
    @SerializedName("vote_average")
    val vote_average: Double,
    @SerializedName("file_path")
    val file_path: String,
    @SerializedName("aspect_ratio")
    val aspect_ratio:Double
)