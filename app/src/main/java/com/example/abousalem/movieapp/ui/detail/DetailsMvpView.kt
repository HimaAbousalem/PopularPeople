package com.example.abousalem.movieapp.ui.detail

import com.example.abousalem.movieapp.data.model.ActorDetails
import com.example.abousalem.movieapp.data.model.ActorPicture
import com.example.abousalem.movieapp.ui.base.BaseMvpView

interface DetailsMvpView : BaseMvpView {
    fun populateDetails(actorDetails: ActorDetails)
    fun populateImages(actorPictures: ActorPicture)
}