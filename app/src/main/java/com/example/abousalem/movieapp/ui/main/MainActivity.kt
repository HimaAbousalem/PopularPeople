package com.example.abousalem.movieapp.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.abousalem.movieapp.R
import com.example.abousalem.movieapp.data.model.Actor
import com.example.abousalem.movieapp.ui.base.BaseActivity
import com.example.abousalem.movieapp.ui.detail.DetailsActivity
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity(), MainMvpView {

    @Inject
    lateinit var mPresenter: MainMvpPresenter<MainMvpView>
    @Inject
    lateinit var gridLayoutManager: GridLayoutManager
    @Inject
    lateinit var groupieAdapter: GroupAdapter<ViewHolder>
    @Inject
    lateinit var picasso: Picasso
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getActivityComponent().inject(this)
        mPresenter.onAttach(this)
        //mPresenter.loadPopularPeople()
        mPresenter.checkInternet()
        actors_recycler.layoutManager = gridLayoutManager
        actors_recycler.adapter = groupieAdapter
        groupieAdapter.setOnItemClickListener { item, _ ->
            this.openDetailsActivity(item)
        }
    }

    override fun populateAdapter(actor: Actor) {
            groupieAdapter.add(ActorItem(actor,picasso))

    }

    override fun openDetailsActivity(item: Item<ViewHolder>) {
        val intent = DetailsActivity.startIntent(this)
        val data = item as ActorItem
        intent.putExtra("Actor", data.actor)
        startActivity(intent)
    }
}
