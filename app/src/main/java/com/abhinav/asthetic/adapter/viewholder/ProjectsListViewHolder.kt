package com.abhinav.asthetic.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.abhinav.asthetic.network.pojo.LatestProject
import com.abhinav.asthetic.utils.fetcher.ImageViewModel
import com.abhinav.asthetic.utils.fetcher.data.ResponseState
import kotlinx.android.synthetic.main.layout_project_single_item.view.*

class ProjectsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var rootLayout: View = itemView.rootView

    private lateinit var projectImageViewModel: ImageViewModel
    private val list = arrayListOf(115, 202, 230, 404, 808)

    fun bind(project: LatestProject) = with(itemView) {
        iv_project.setImageBitmap(null)
        tv_project_name.text = project.name
        tv_owner_name.text = when (project.owners?.size) {
            1 -> project.owners!![0].displayName
            else -> "Multiple Users"
        }
        if (project.fields?.isNotEmpty()!!)
            tv_fields.text = project.fields?.get(0)
        else tv_fields.text = "Fallback"
        tv_likes.text = project.stats?.appreciations.toString()
        tv_views.text = project.stats?.views.toString()

        project.covers?.let {
            projectImageViewModel = ImageViewModel("projects", it.small?.substringAfterLast("/")!!)
            projectImageViewModel.loadImages(list)

            projectImageViewModel.bitmapResult.observeForever {
                it?.let {
                    when (it.state) {
                        ResponseState.LOADING -> {

                        }
                        ResponseState.ERROR -> {

                        }
                        ResponseState.SUCCESS -> {
                            it.bitmap?.let { bitmap ->
                                iv_project.setImageBitmap(bitmap)
                            }
                        }
                    }
                }
            }

        }
    }

    fun onViewDetached() {
        projectImageViewModel.unSubscribe()
    }
}
