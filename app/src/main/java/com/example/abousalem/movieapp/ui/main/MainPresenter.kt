package com.example.abousalem.movieapp.ui.main

import com.example.abousalem.movieapp.data.DataManager
import com.example.abousalem.movieapp.data.model.Actor
import com.example.abousalem.movieapp.ui.base.BasePresenter
import com.example.abousalem.movieapp.util.Constants
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter<V:MainMvpView>: BasePresenter<V>, MainMvpPresenter<V>{

    @Inject
    constructor(mDataManager: DataManager, mCompositeDisposable: CompositeDisposable) : super(
        mDataManager,
        mCompositeDisposable
    )
    override fun loadPopularPeople() {
        getBaseMvpView().showLoading()
        getCompositeDisposable().add(
        getDataManager().getPopularPeople()
            .subscribeOn(Schedulers.io())
            .map{actors -> actors.moviesResult}
            .flatMap {Observable.fromIterable(it) }
            .map { actor->
                actor.actorProfilePic = Constants.BASE_IMAGE_URL + actor.actorProfilePic
                return@map actor }
            .toList()
            .observeOn(AndroidSchedulers. mainThread())
            .subscribe {it ->getBaseMvpView().populateAdapter(it)
            getBaseMvpView().hideloading()})
    }

}