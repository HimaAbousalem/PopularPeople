package com.example.abousalem.movieapp.ui.base

import androidx.annotation.StringRes

interface BaseMvpView {

    fun showLoading()
    fun hideloading()
    fun onError(@StringRes resId: Int)
    fun onError(message: String)
    fun showMessage(message: String)
    fun showMessage(@StringRes resId: Int)
    fun isNetworkConnected(): Boolean

}