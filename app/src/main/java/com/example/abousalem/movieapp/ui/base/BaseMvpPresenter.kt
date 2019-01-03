package com.example.abousalem.movieapp.ui.base

interface BaseMvpPresenter <V: BaseMvpView>{

    fun onAttach(mvpView: V)
    fun onDetach()
}