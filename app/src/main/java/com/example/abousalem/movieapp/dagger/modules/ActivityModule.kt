package com.example.abousalem.movieapp.dagger.modules

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.abousalem.movieapp.dagger.ActivityContext
import com.example.abousalem.movieapp.dagger.ActivityScope
import com.example.abousalem.movieapp.ui.main.MainMvpPresenter
import com.example.abousalem.movieapp.ui.main.MainMvpView
import com.example.abousalem.movieapp.ui.main.MainPresenter
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule{
    var mActivity: AppCompatActivity

    constructor(mActivity: AppCompatActivity) {
        this.mActivity = mActivity
    }

    @Provides
    @ActivityContext
    fun provideContext(): Context {
        return mActivity
    }

    @Provides
    fun provideActivity(): AppCompatActivity {
        return mActivity
    }

    @Provides
    fun provideCompositeDisposable():CompositeDisposable{
        return CompositeDisposable()
    }

    @Provides
    fun provideLinearLayoutManager(activity: AppCompatActivity): LinearLayoutManager {
        return LinearLayoutManager(activity)
    }

    @ActivityScope
    @Provides
    fun provideMainPresenter(mPresenter: MainPresenter<MainMvpView>): MainMvpPresenter<MainMvpView> {
        return mPresenter
    }

    @ActivityScope
    @Provides
    fun provideGroupiAdapter(): GroupAdapter<ViewHolder> {
        return GroupAdapter<ViewHolder>()
    }

}