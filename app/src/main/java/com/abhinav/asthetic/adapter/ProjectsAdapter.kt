package com.abhinav.asthetic.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.abhinav.asthetic.R
import com.abhinav.asthetic.adapter.viewholder.ProjectsViewHolder
import com.abhinav.asthetic.network.pojo.LatestProject
import com.abhinav.asthetic.utils.inflate

/**
 * Created by appinventiv on 25/4/18.
 */
class ProjectsAdapter(private val listener: (LatestProject) -> Unit) : RecyclerView.Adapter<ProjectsViewHolder>() {

    private val allProject = ArrayList<LatestProject>()
    private var lastPosition: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsViewHolder =
            ProjectsViewHolder(parent.inflate(R.layout.layout_project_single_item))

    override fun getItemCount(): Int = allProject.size

    private fun getItem(position: Int) = allProject[position]

    override fun onBindViewHolder(holder: ProjectsViewHolder, position: Int) {
        holder.bind(getItem(position))
        setAnimation(holder.rootLayout, position)
        holder.rootLayout.setOnClickListener { listener.invoke(getItem(position)) }
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

    fun setAnimation(viewToAnimate: View, position: Int) {
        if (position >= lastPosition) {
            val animation = AnimationUtils.loadAnimation(viewToAnimate.context, R.anim.item_animation_from_bottom)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }

    override fun onViewDetachedFromWindow(holder: ProjectsViewHolder?) {
        super.onViewDetachedFromWindow(holder)
        holder?.rootLayout!!.clearAnimation()
    }
}