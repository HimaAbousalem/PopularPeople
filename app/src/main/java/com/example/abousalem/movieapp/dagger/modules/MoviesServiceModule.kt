package com.example.abousalem.movieapp.dagger.modules

import android.content.Context
import com.example.abousalem.movieapp.api.MovieApi
import com.example.abousalem.movieapp.dagger.AppScope
import com.example.abousalem.movieapp.dagger.ApplicationContext
import com.example.abousalem.movieapp.data.DataManager
import com.example.abousalem.movieapp.util.Constants
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [NetworkModule::class])
class MoviesServiceModule{

    @AppScope
    @Provides
    fun getMovieService(retrofit : Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }

    @AppScope
    @Provides
    fun getRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.MOVIE_BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @AppScope
    @Provides
    fun getDataManger(@ApplicationContext context: Context):DataManager{
        return DataManager(context)
    }

    @AppScope
    @Provides
    fun getNetworkObservable(@ApplicationContext context: Context): Observable<Connectivity> {
            return ReactiveNetwork.observeNetworkConnectivity(context)
    }

}

