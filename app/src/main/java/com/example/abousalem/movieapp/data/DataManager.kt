package com.example.abousalem.movieapp.data

import android.content.Context
import com.example.abousalem.movieapp.BuildConfig
import com.example.abousalem.movieapp.application.MovieApp
import com.example.abousalem.movieapp.data.model.ActorDetails
import com.example.abousalem.movieapp.data.model.MoviesRequest
import com.example.abousalem.movieapp.data.model.PicturesRequest
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class DataManager{
    var context: Context? =null
    @Inject
    constructor(context: Context){
        this.context = context
    }

    fun getPopularPeople(): Observable<MoviesRequest> {
        return MovieApp.get(context!!).movieApiService.getPopularPeople(
            BuildConfig.MOVIE_DB_API_TOKEN,
            1 )
    }
    fun getActorImages(id: Long): Observable<PicturesRequest> {
        return MovieApp.get(context!!).movieApiService.getActorImages(
            id,
            BuildConfig.MOVIE_DB_API_TOKEN)
    }

    fun getActorDetails(id: Long): Observable<ActorDetails> {
        return MovieApp.get(context!!).movieApiService.getActorDetails(
            id,
            BuildConfig.MOVIE_DB_API_TOKEN
        )
    }
}