package com.example.abousalem.movieapp.ui.detail

import com.example.abousalem.movieapp.R
import com.example.abousalem.movieapp.data.model.ActorDetails
import com.squareup.picasso.Picasso
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.details_header.view.*
import javax.inject.Inject

class HeaderRow @Inject constructor(private val actorDetails: ActorDetails, val picasso: Picasso): Item<ViewHolder>() {
    override fun getLayout(): Int {
        return R.layout.details_header
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        val data = viewHolder.itemView
        picasso.load(actorDetails.profilePic).into(data.profile_pic_details_activity)
        data.name_details_activity.text = actorDetails.name
        data.birthday_details_activity.text = actorDetails.birthday
        data.biography_txt.text = actorDetails.biography
        data.born_details_activity.text = actorDetails.placeOfBirth
        data.popularity_text.text = (actorDetails.popularity).toString()
        data.job_details_activity.text = actorDetails.knownForDepartment
    }

}