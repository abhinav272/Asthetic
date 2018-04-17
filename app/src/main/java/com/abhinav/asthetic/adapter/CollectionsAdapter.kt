package com.abhinav.asthetic.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.abhinav.asthetic.R
import com.abhinav.asthetic.adapter.viewholder.CollectionsViewHolder
import com.abhinav.asthetic.network.pojo.Collection
import com.abhinav.asthetic.utils.inflate


/**
 * Created by abhinav.sharma on 08/01/18.
 */
class CollectionsAdapter(private val listener: (Collection) -> Unit, private var collectionsList: ArrayList<Collection>) : RecyclerView.Adapter<CollectionsViewHolder>() {

    override fun getItemCount(): Int = collectionsList.size

    private fun getItem(position: Int): Collection = collectionsList[position]

    override fun onBindViewHolder(holder: CollectionsViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
        setAnimation(holder.itemView, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionsViewHolder =
            CollectionsViewHolder(parent.inflate(R.layout.layout_collection_single_item))

    fun updateDataSet(collections: List<Collection>) {
        collectionsList.addAll(collections)
        notifyDataSetChanged()
    }

    private var lastPosition: Int = 0

    fun setAnimation(viewToAnimate: View, position: Int) {
        if (position > lastPosition) {
            val animation = AnimationUtils.loadAnimation(viewToAnimate.context, android.R.anim.fade_in)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }

    override fun onViewDetachedFromWindow(holder: CollectionsViewHolder?) {
        super.onViewDetachedFromWindow(holder)
        holder?.rootLayout!!.clearAnimation()
    }
}

