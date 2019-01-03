package com.example.abousalem.movieapp.ui.base

import com.example.abousalem.movieapp.data.DataManager
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

open class BasePresenter<V:BaseMvpView>: BaseMvpPresenter<V>{

    private var mBaseMvpView: V? = null
    private val mCompositeDisposable: CompositeDisposable
    private val mDataManager: DataManager

    @Inject
    constructor(mDataManager: DataManager, mCompositeDisposable: CompositeDisposable) {
        this.mCompositeDisposable = mCompositeDisposable
        this.mDataManager = mDataManager
    }

    override fun onAttach(mvpView: V) {
        mBaseMvpView = mvpView
    }

    override fun onDetach() {
        mCompositeDisposable.dispose()
        mBaseMvpView= null
    }

    fun isViewAttached(): Boolean{
        return mBaseMvpView !=null
    }

    fun getBaseMvpView(): V {
        return mBaseMvpView!!
    }
    fun getDataManager():DataManager{
        return mDataManager
    }
    fun getCompositeDisposable():CompositeDisposable{
        return mCompositeDisposable
    }

}