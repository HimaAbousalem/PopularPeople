package com.example.abousalem.movieapp.dagger.modules

import android.content.Context
import com.example.abousalem.movieapp.dagger.AppScope
import com.example.abousalem.movieapp.dagger.ApplicationContext
import com.example.abousalem.movieapp.util.Constants
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.io.File


@Module(includes = [AppModule::class])
class NetworkModule{

    @AppScope
    @Provides
    fun cache(@ApplicationContext context:Context): Cache{
        return Cache(File(context.cacheDir,Constants.HTTP_CACHE_DIR), Constants.HTTP_CACHE_SIZE.toLong())
    }

    @AppScope
    @Provides
    fun okHttpClient(loggingInterceptor: HttpLoggingInterceptor, cache: Cache): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .cache(cache)
            .build()
    }

    @AppScope
    @Provides
    fun httpLoggingInterceptor():HttpLoggingInterceptor{
        val logging = HttpLoggingInterceptor{ message -> Timber.d(message)  }
        return logging.setLevel(HttpLoggingInterceptor.Level.BASIC)


    }

}