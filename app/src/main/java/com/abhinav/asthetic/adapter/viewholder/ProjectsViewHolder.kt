package com.abhinav.asthetic.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.abhinav.asthetic.network.pojo.LatestProject
import kotlinx.android.synthetic.main.layout_project_single_item.view.*

class ProjectsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var rootLayout: View = itemView.rootView

    fun bind(project: LatestProject) = with(itemView) {
        tv_project_name.text = project.name

        tv_owner_name.text = when (project.owners?.size) {
            1 -> project.owners!![0].displayName
            else -> "Multiple Users"
        }

        tv_fields.text = project.fields?.get(0) ?: "Fallback Fields"
        tv_likes.text = project.stats?.appreciations.toString()
        tv_views.text = project.stats?.views.toString()
    }
}
