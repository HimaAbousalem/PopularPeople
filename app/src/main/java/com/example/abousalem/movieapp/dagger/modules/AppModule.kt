package com.example.abousalem.movieapp.dagger.modules

import dagger.Module
import dagger.Provides
import android.content.Context
import com.example.abousalem.movieapp.dagger.AppScope
import com.example.abousalem.movieapp.dagger.ApplicationContext

@Module
class AppModule{

    var context: Context?= null

    constructor(context: Context){
        this.context = context
    }

    @AppScope
    @ApplicationContext
    @Provides
    fun getApplication(): Context {
        return context!!
    }
}