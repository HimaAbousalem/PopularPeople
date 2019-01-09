package com.example.abousalem.movieapp.ui.detail

import com.example.abousalem.movieapp.data.DataManager
import com.example.abousalem.movieapp.data.model.Actor
import com.example.abousalem.movieapp.ui.base.BasePresenter
import com.example.abousalem.movieapp.util.Constants
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailsPresenter<V: DetailsMvpView>: BasePresenter<V>,DetailsMvpPresenter<V>{

    @Inject
    constructor(mDataManager: DataManager, mCompositeDisposable: CompositeDisposable) : super(
        mDataManager,
        mCompositeDisposable
    )

    override fun fetchActorDetails(actor: Actor) {
        getCompositeDisposable().add(getDataManager().getActorDetails(actor.id)
            .subscribeOn(Schedulers.io())
            .map{actor ->
                actor.profilePic = Constants.BASE_IMAGE_URL + actor.profilePic
            return@map actor}
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                getBaseMvpView().populateDetails(it)
            })
    }

    override fun fetchActorPictures(actor: Actor) {
        getCompositeDisposable().add(getDataManager().getActorImages(actor.id)
            .subscribeOn(Schedulers.io())
            .map { actorImages -> actorImages.profilePictures}
            .flatMap { Observable.fromIterable(it) }
            .map { actorImage ->
                actorImage.file_path = Constants.BASE_IMAGE_URL + actorImage.file_path
            return@map actorImage}
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                getBaseMvpView().populateImages(it)
            })
    }
}