package com.abhinav.asthetic.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.abhinav.asthetic.R
import com.abhinav.asthetic.adapter.viewholder.CollectionsViewHolder
import com.abhinav.asthetic.network.pojo.Collection
import com.abhinav.asthetic.utils.inflate
import com.abhinav.asthetic.utils.random

/**
 * Created by abhinav.sharma on 08/01/18.
 */
class CollectionsAdapter(private val listener: (Collection) -> Unit, private var collectionsList: List<Collection>) : RecyclerView.Adapter<CollectionsViewHolder>() {

    init {
        collectionsList.forEach {
            it.height = (400..800).random()
        }
    }

    override fun getItemCount(): Int = collectionsList.size

    private fun getItem(position: Int): Collection = collectionsList[position]

    override fun onBindViewHolder(holder: CollectionsViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionsViewHolder =
            CollectionsViewHolder(parent.inflate(R.layout.layout_collection_single_item))
}

