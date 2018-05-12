package com.abhinav.asthetic.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.abhinav.asthetic.R
import com.abhinav.asthetic.network.pojo.Collection
import com.abhinav.asthetic.utils.ResourceUtil
import com.abhinav.asthetic.utils.getFormatedDate
import com.abhinav.asthetic.utils.load
import kotlinx.android.synthetic.main.layout_collection_details_single_item.view.*

/**
 * Created by appinventiv on 7/5/18.
 */
open class CollectionSummaryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var rootLayout: View = itemView.rootView

    fun bind(collection: Collection) = with(itemView) {
        if (collection.owners?.isNotEmpty()!!) {
            collection.owners!![0].images?.fullImage?.let {
                iv_user.load(it) { requestCreator ->
                    requestCreator.fit().centerCrop()
                }
            }
            tv_user_name.text = collection.owners!![0].displayName
        }

        tv_collection_name.text = collection.title
        tv_followers_placeholder.text = String.format(ResourceUtil.getString(R.string.followers_title),
                collection.stats!!.followers)
        tv_projects_placeholder.text = String.format(ResourceUtil.getString(R.string.projects_title),
                collection.stats!!.items)
        tv_created_on.text = collection.createdOn?.getFormatedDate()
        tv_updated_on.text = collection.updatedOn?.getFormatedDate()
    }
}