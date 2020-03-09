package com.vincent.ui.stores

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vincent.data.entity.Store
import com.vincent.ui.R
import kotlinx.android.synthetic.main.fragment_store_details.*

import kotlinx.android.synthetic.main.view_stores_item.view.*
import kotlinx.android.synthetic.main.view_stores_item.view.iv_logo

internal class StoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var store: Store

    fun bind(store: Store) {
        this.store = store

        itemView.tv_location.text = "${store.address.city}, ${store.address.state}"
        itemView.tv_name.text = store.name

       setLogo(store.logoUrl)
    }

    private fun setLogo(url: String) {
        Picasso.get()
            .load(url)
            .resizeDimen(R.dimen.logo_width, R.dimen.logo_height)
            .centerInside()
            .into(itemView.iv_logo)
    }
}