package com.example.abousalem.movieapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class MoviesRequest (
    @SerializedName("page")
    val page: String,
    @SerializedName("total_result")
    val totalResult: String,
    @SerializedName("total_pages")
    val totalPage: String,
    @SerializedName("results")
    val moviesResult: ArrayList<Actor>) : Parcelable