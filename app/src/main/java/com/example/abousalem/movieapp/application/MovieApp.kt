package com.example.abousalem.movieapp.application

import android.app.Activity
import android.app.Application
import android.content.Context
import com.example.abousalem.movieapp.api.MovieApi
import com.example.abousalem.movieapp.dagger.components.DaggerMovieAppComponent
import com.example.abousalem.movieapp.dagger.components.MovieAppComponent
import com.example.abousalem.movieapp.dagger.modules.AppModule
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject

class MovieApp : Application(){

    @Inject
    lateinit var picasso: Picasso
    @Inject
    lateinit var movieApiService: MovieApi
    @Inject
    lateinit var reactiveNetwork: Observable<Connectivity>

    private lateinit var component: MovieAppComponent

    companion object {
        fun get(context: Context):MovieApp{
            return context.applicationContext as MovieApp
        }
    }
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        component = DaggerMovieAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        component.injectMovieApplication(this)

    }

    fun getApplicationComponent(): MovieAppComponent {
        return component
    }

    fun getPicassoObj():Picasso{
        return picasso
    }

}