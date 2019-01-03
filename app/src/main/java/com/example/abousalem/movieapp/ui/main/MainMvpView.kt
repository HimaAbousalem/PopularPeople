package com.example.abousalem.movieapp.ui.main

import com.example.abousalem.movieapp.data.model.Actor
import com.example.abousalem.movieapp.ui.base.BaseMvpView

interface MainMvpView: BaseMvpView{
    //declare Main View Methods
    fun populateAdapter(actors: List<Actor>)
}