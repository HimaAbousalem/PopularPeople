package com.example.abousalem.movieapp.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.abousalem.movieapp.R
import com.example.abousalem.movieapp.data.model.Actor
import com.example.abousalem.movieapp.data.model.ActorDetails
import com.example.abousalem.movieapp.data.model.ActorPicture
import com.example.abousalem.movieapp.ui.base.BaseActivity
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.recycler_picture_details.*
import javax.inject.Inject

class DetailsActivity : BaseActivity(), DetailsMvpView {

    @Inject
    lateinit var mPresenter: DetailsMvpPresenter<DetailsMvpView>
    @Inject
    lateinit var groupieAdapter: GroupAdapter<ViewHolder>
    @Inject
    lateinit var picasso: Picasso

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val actorData = intent.getParcelableExtra<Actor>("Actor")
        getActivityComponent().inject(this)
        mPresenter.onAttach(this)
        mPresenter.fetchActorDetails(actorData)
        mPresenter.fetchActorPictures(actorData)
        val layoutManager = GridLayoutManager(this, 5)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                if (position == 0)
                    return 5
                return 1
            }

        }
        pictures_details_recycler.layoutManager =layoutManager
        pictures_details_recycler.adapter = groupieAdapter

    }
    companion object {
        fun startIntent(context: Context): Intent {
            return Intent(context, DetailsActivity::class.java)
        }
    }

    override fun populateDetails(actorDetails: ActorDetails) {
        groupieAdapter.add(0,HeaderRow(actorDetails, picasso))
        pictures_details_recycler.scrollToPosition(0)
    }

    override fun populateImages(actorPictures: ActorPicture) {
        groupieAdapter.add(RecyclerRow(actorPictures, picasso))
    }
}
