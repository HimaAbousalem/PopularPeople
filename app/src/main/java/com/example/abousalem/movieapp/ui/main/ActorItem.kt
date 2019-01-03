package com.example.abousalem.movieapp.ui.main

import com.example.abousalem.movieapp.R
import com.example.abousalem.movieapp.data.model.Actor
import com.squareup.picasso.Picasso
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.actor_recycler_row.view.*
import javax.inject.Inject

class ActorItem @Inject constructor(val actor: Actor, val picasso: Picasso): Item<ViewHolder>(){
    override fun getLayout(): Int {
        return R.layout.actor_recycler_row
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.actor_name_recycler.text = actor.actorName
        picasso.load(actor.actorProfilePic).into(viewHolder.itemView.actor_image_recycler)
    }

}