package com.example.abousalem.movieapp.api

import com.example.abousalem.movieapp.data.model.MoviesRequest
import com.example.abousalem.movieapp.data.model.PicturesRequest
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi{

  /*  @GET("movie/{type}")
    fun getMovies(@Path("type")movieType: String,
                  @Query("api_key")api_key: String): Flowable<MoviesRequest>

    @GET("movie/{id}/videos")
    fun getTrailers(@Path("id")movieId: String,
                    @Query("api_key")api_key: String): Flowable<MoviesRequest>*/
  @GET("person/popular")
  fun getPopularPeople(@Query("api_key") api_key: String,
                       @Query("page")page: Int):Observable<MoviesRequest>

  @GET("/person/{id}/images")
  fun getActorImages(@Path("id")actorId: Long,
                     @Query("api_key") api_key: String):Single<PicturesRequest>
}