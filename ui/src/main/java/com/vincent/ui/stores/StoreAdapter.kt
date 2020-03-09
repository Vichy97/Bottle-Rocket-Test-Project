package com.vincent.ui.stores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vincent.data.entity.Store
import com.vincent.ui.R

internal class StoreAdapter(
    private val callback: OnStoreClickedCallback
) : RecyclerView.Adapter<StoreViewHolder>() {

    private val stores: MutableList<Store> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_stores_item, parent, false)

        return StoreViewHolder(itemView)
    }

    override fun getItemCount() = stores.size

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        holder.bind(stores[position])
        holder.itemView.setOnClickListener { callback.onStoreClicked(stores[position].id) }
    }

    fun setStores(stores: List<Store>) {
        this.stores.clear()
        this.stores.addAll(stores)
        notifyDataSetChanged()
    }

    fun clear() {
        stores.clear()
    }

    interface OnStoreClickedCallback {

        fun onStoreClicked(storeId: String)
    }
}