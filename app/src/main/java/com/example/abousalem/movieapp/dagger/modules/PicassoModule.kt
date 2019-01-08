package com.example.abousalem.movieapp.dagger.modules

import android.content.Context
import com.example.abousalem.movieapp.dagger.AppScope
import com.example.abousalem.movieapp.dagger.ApplicationContext
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module(includes = [NetworkModule::class])
class PicassoModule{

    @AppScope
    @Provides
    fun getPicasso(@ApplicationContext context: Context, okHttp3Downloader: OkHttp3Downloader): Picasso{
        return Picasso.Builder(context)
            .downloader(okHttp3Downloader)
            .build()
    }

    @AppScope
    @Provides
    fun getOkHttp3Downloader(okHttpClient: OkHttpClient):OkHttp3Downloader{
        return OkHttp3Downloader(okHttpClient)
    }
}