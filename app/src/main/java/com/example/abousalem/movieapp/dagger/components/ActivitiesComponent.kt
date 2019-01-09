package com.example.abousalem.movieapp.dagger.components

import com.example.abousalem.movieapp.dagger.ActivityScope
import com.example.abousalem.movieapp.dagger.modules.ActivityModule
import com.example.abousalem.movieapp.ui.detail.DetailsActivity
import com.example.abousalem.movieapp.ui.main.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [MovieAppComponent::class],modules = [ActivityModule::class])
interface ActivitiesComponent{
    fun inject(activity: MainActivity)
    fun inject(activity: DetailsActivity)
}