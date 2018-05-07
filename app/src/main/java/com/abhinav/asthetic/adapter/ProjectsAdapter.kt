package com.abhinav.asthetic.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.abhinav.asthetic.R
import com.abhinav.asthetic.adapter.viewholder.CollectionSummaryViewHolder
import com.abhinav.asthetic.adapter.viewholder.ProjectsListViewHolder
import com.abhinav.asthetic.network.pojo.Collection
import com.abhinav.asthetic.network.pojo.LatestProject
import com.abhinav.asthetic.utils.inflate

/**
 * Created by appinventiv on 25/4/18.
 */
class ProjectsAdapter(private val listener: (LatestProject) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val allProject = ArrayList<LatestProject>()
    private var lastPosition: Int = 0
    private var collection: Collection? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            when (viewType) {
                TYPE_ITEM -> ProjectsListViewHolder(parent.inflate(R.layout.layout_project_single_item))
                else -> CollectionSummaryViewHolder(parent.inflate(R.layout.layout_collection_details_single_item))
            }

    override fun getItemCount(): Int = allProject.size + 1

    private fun getItem(position: Int): LatestProject? {
        if (position == 0)
            return null
        return allProject[position - 1]
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ProjectsListViewHolder -> {
                getItem(position)?.let { holder.bind(it) }
                setAnimation(holder.rootLayout, position)
                holder.rootLayout.setOnClickListener { listener.invoke(getItem(position)!!) }
            }
            is CollectionSummaryViewHolder -> {
                collection?.let { holder.bind(collection!!) }
            }
        }
    }

    fun populateProjects(allItems: List<LatestProject>) {
        val position = allProject.size
        allProject.addAll(allItems)
        notifyItemRangeInserted(position, allItems.size)
    }

    fun rePopulateProjects(allItems: List<LatestProject>) {
        allProject.clear()
        allProject.addAll(allItems)
        notifyDataSetChanged()
    }

    fun populateCollectionSummary(collection: Collection) {
        this.collection = collection
        notifyItemChanged(0)
    }

    private fun setAnimation(viewToAnimate: View, position: Int) {
        if (position >= lastPosition) {
            val animation = AnimationUtils.loadAnimation(viewToAnimate.context, R.anim.item_animation_from_bottom)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }

    val TYPE_HEADER = 1
    val TYPE_ITEM = 2

    override fun getItemViewType(position: Int): Int {
        if (position == 0)
            return TYPE_HEADER
        return TYPE_ITEM
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder?) {
        super.onViewDetachedFromWindow(holder)
        holder?.itemView?.rootView?.clearAnimation()
    }
}
