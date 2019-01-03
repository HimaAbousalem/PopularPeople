package com.example.abousalem.movieapp.dagger.components

import com.example.abousalem.movieapp.application.MovieApp
import com.example.abousalem.movieapp.dagger.AppScope
import com.example.abousalem.movieapp.dagger.modules.MoviesServiceModule
import com.example.abousalem.movieapp.dagger.modules.PicassoModule
import dagger.Component

@AppScope
@Component(modules = [MoviesServiceModule::class, PicassoModule::class])
interface  MovieAppComponent{
    fun injectMovieApplication(application: MovieApp)
}