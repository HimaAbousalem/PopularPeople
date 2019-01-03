package com.example.abousalem.movieapp.ui.main

import com.example.abousalem.movieapp.ui.base.BaseMvpPresenter

interface  MainMvpPresenter<V: MainMvpView>: BaseMvpPresenter<V>{

    fun loadPopularPeople()

}