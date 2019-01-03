package com.example.abousalem.movieapp.data.model

import com.google.gson.annotations.SerializedName

data class PicturesRequest(
    @SerializedName("id")
    val id: Long,
    @SerializedName("profiles")
    val profilePictures: ArrayList<ActorPicture>
)