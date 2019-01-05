package com.example.abousalem.movieapp.data.model

import com.google.gson.annotations.SerializedName


data class ActorPicture(
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("file_path")
    val file_path: String,
    @SerializedName("aspect_ratio")
    val aspect_ratio:Double
)