package com.example.abousalem.movieapp.ui.main

import android.net.NetworkInfo
import com.example.abousalem.movieapp.data.DataManager
import com.example.abousalem.movieapp.ui.base.BasePresenter
import com.example.abousalem.movieapp.util.Constants
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity
import com.github.pwittchen.reactivenetwork.library.rx2.ConnectivityPredicate
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter<V:MainMvpView>: BasePresenter<V>, MainMvpPresenter<V> {

    @Inject
    constructor(mDataManager: DataManager, mCompositeDisposable: CompositeDisposable) : super(
        mDataManager,
        mCompositeDisposable
    )

    @Inject
    lateinit var reactiveNetwork: Observable<Connectivity>

    override fun loadPopularPeople() {
        getCompositeDisposable().add(reactiveNetwork
            .filter(ConnectivityPredicate.hasState(NetworkInfo.State.CONNECTED))
            .flatMap { getDataManager().getPopularPeople() }
            .subscribeOn(Schedulers.io())
            .map {
                    actors -> actors.moviesResult }
            .flatMap { Observable.fromIterable(it) }
         /*   .map {
                    actor ->
                actor.actorProfilePic = Constants.BASE_IMAGE_URL + actor.actorProfilePic

            }*/
            .toList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { it ->
                getBaseMvpView().populateAdapter(it)
                getBaseMvpView().hideloading()
            })
    }
}
    /*override fun loadPopularPeople(){
        getBaseMvpView().showLoading()
        getCompositeDisposable().add(
            getDataManager().getPopularPeople()
                .subscribeOn(Schedulers.io())
                .map{actors -> actors.moviesResult}
                .flatMapS {Observable.fromIterable(it) }
                .map { actor->
                    actor.actorProfilePic = Constants.BASE_IMAGE_URL + actor.actorProfilePic
                    return@map actor }
                .toList()
                .observeOn(AndroidSchedulers. mainThread())
                .subscribe {it ->getBaseMvpView().populateAdapter(it)
                    getBaseMvpView().hideloading()})
    }*/
