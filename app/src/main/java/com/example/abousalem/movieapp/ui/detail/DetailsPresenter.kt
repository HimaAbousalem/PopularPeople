package com.example.abousalem.movieapp.ui.detail

import com.example.abousalem.movieapp.data.DataManager
import com.example.abousalem.movieapp.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class DetailsPresenter<V: DetailsMvpView>: BasePresenter<V>,DetailsMvpPresenter<V>{

    @Inject
    constructor(mDataManager: DataManager, mCompositeDisposable: CompositeDisposable) : super(
        mDataManager,
        mCompositeDisposable
    )
}