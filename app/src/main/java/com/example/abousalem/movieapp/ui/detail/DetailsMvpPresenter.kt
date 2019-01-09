package com.example.abousalem.movieapp.ui.detail

import com.example.abousalem.movieapp.data.model.Actor
import com.example.abousalem.movieapp.ui.base.BaseMvpPresenter

interface DetailsMvpPresenter<V: DetailsMvpView>: BaseMvpPresenter<V> {
    fun fetchActorDetails(actor: Actor)
    fun fetchActorPictures(actor: Actor)
}