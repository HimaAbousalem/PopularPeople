package com.example.abousalem.movieapp.ui.detail

import com.example.abousalem.movieapp.R
import com.example.abousalem.movieapp.data.model.ActorPicture
import com.squareup.picasso.Picasso
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.recycler_picture_details.view.*
import javax.inject.Inject

class RecyclerRow @Inject constructor(private val actorPicture: ActorPicture, val picasso: Picasso): Item<ViewHolder>(){
    override fun getLayout(): Int {
        return R.layout.recycler_picture_details
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        picasso.load(actorPicture.file_path).into(viewHolder.itemView.row_images_details)
    }

}