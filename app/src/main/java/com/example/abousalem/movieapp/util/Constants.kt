package com.example.abousalem.movieapp.util

class Constants{

    companion object {
        val MOVIE_BASE_URL =  "http://api.themoviedb.org/3/"
        val BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w185"
        val MOVIE_POPULAR_TYPE = "popular"
        val MOVIE_TOP_RATED_TYPE  = "top_rated"
        val HTTP_CACHE_DIR = "okhttp_cache"
        val HTTP_CACHE_SIZE = 10 * 1024 * 1024 //10MB
        val databaseName = "movies.db"

    }
}