package com.example.abousalem.movieapp.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.abousalem.movieapp.R
import com.example.abousalem.movieapp.data.model.Actor
import com.example.abousalem.movieapp.ui.base.BaseActivity
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
        actors_recycler.layoutManager = gridLayoutManager
        actors_recycler.adapter = groupieAdapter
        mPresenter.loadPopularPeople()
        groupieAdapter.setOnItemClickListener { item, _ ->
            this.openDetailsActivity(item)
        }
    }
    override fun populateAdapter(actors: List<Actor>) {
        if (actors.isEmpty()){
            Toast.makeText(this, "NO DATA HERE !!", Toast.LENGTH_SHORT).show()
            return
        }
        Toast.makeText(this, "there is data!!", Toast.LENGTH_SHORT).show()
        actors.forEach {
            groupieAdapter.add(ActorItem(it,picasso))
        }
    }
    override fun openDetailsActivity(item: Item<ViewHolder>) {

    }


}
