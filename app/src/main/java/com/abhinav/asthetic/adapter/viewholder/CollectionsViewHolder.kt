package com.abhinav.asthetic.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.abhinav.asthetic.network.pojo.Collection
import com.abhinav.asthetic.utils.load
import kotlinx.android.synthetic.main.layout_collection_single_item.view.*

/**
 * Created by abhinav.sharma on 08/01/18.
 */
class CollectionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(collection: Collection, listener: (Collection) -> Unit) = with(itemView) {
        iv_collection.layoutParams.height = collection.height

        iv_collection.setOnClickListener {
            listener.invoke(collection)
        }
        if (collection.projectCovers != null && !collection.projectCovers!!.isEmpty()) {
            iv_collection.load(collection.projectCovers!![0].url!!) { requestCreator ->
                requestCreator.fit().centerCrop()
            }
        }
    }
}