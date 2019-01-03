package com.example.abousalem.movieapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.abousalem.movieapp.R
import com.example.abousalem.movieapp.data.model.Actor
import com.example.abousalem.movieapp.ui.base.BaseActivity
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject


class MainActivity : BaseActivity(), MainMvpView {

    @Inject
    lateinit var mPresenter: MainMvpPresenter<MainMvpView>
    @Inject
    lateinit var linerLayoutManager: LinearLayoutManager
    @Inject
    lateinit var groupieAdapter: GroupAdapter<ViewHolder>
    @Inject
    lateinit var picasso: Picasso
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getActivityComponent().inject(this)
        mPresenter.onAttach(this)
        actors_recycler.layoutManager = linerLayoutManager
        actors_recycler.adapter = groupieAdapter
    }
    override fun populateAdapter(actors: List<Actor>) {
        actors.forEach {
            groupieAdapter.add(ActorItem(it,picasso))
        }
    }

}
