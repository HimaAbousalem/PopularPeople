package com.example.abousalem.movieapp.ui.base

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.abousalem.movieapp.R
import com.example.abousalem.movieapp.application.MovieApp
import com.example.abousalem.movieapp.dagger.components.ActivitiesComponent
import com.example.abousalem.movieapp.dagger.components.DaggerActivitiesComponent
import com.example.abousalem.movieapp.dagger.modules.ActivityModule
import com.example.abousalem.movieapp.util.Connection
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

open class BaseActivity: AppCompatActivity(), BaseMvpView{

    @Inject
    lateinit var mActivitiesComponent: ActivitiesComponent
    private lateinit var mDialoge: DialogView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDialoge = DialogView(this)
        mActivitiesComponent = DaggerActivitiesComponent.builder()
            .activityModule(ActivityModule(this))
            .movieAppComponent((application as MovieApp).getApplicationComponent())
            .build()

    }

    fun getActivityComponent(): ActivitiesComponent{
        return mActivitiesComponent
    }
    override fun showLoading() {
        hideloading()
        mDialoge.showDialog()
    }

    override fun hideloading() {
        mDialoge.hideDialog()
    }

    private fun showSnackBar(message: String) {
        val snackBar = Snackbar.make(
            findViewById(android.R.id.content),
            message, Snackbar.LENGTH_SHORT
        )
        val sbView = snackBar.view
        val textView = sbView
            .findViewById(R.id.snackbar_text) as TextView
        textView.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        snackBar.show()
    }

    override fun onError(@StringRes resId: Int) {
        onError(getString(resId))
    }

    override fun onError(message: String) {
        if (message != null) {
            showSnackBar(message)
        } else {
            showSnackBar(getString(R.string.some_error))
        }
    }

    override fun showMessage(message: String) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show()
        }
    }

    override fun showMessage(@StringRes resId: Int) {
        showMessage(getString(resId))
    }

    override fun isNetworkConnected(): Boolean {
        return Connection.isNetworkConnected(applicationContext)
    }
}