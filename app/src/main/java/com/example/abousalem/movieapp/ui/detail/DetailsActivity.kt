package com.example.abousalem.movieapp.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.abousalem.movieapp.R
import com.example.abousalem.movieapp.data.model.Actor
import com.example.abousalem.movieapp.ui.base.BaseActivity
import com.squareup.picasso.Picasso
import javax.inject.Inject

class DetailsActivity : BaseActivity(), DetailsMvpView {

    companion object {
        fun startIntent(context: Context): Intent {
            return Intent(context, DetailsActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
       // val actorData = intent.getParcelableExtra<Actor>("Actor")

    }
}
