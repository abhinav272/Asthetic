package com.abhinav.asthetic.adapter.viewholder

import android.graphics.Bitmap
import android.support.v7.widget.RecyclerView
import android.view.View
import com.abhinav.asthetic.network.pojo.Collection
import com.abhinav.asthetic.utils.fetcher.ImageViewModel
import com.abhinav.asthetic.utils.fetcher.data.BitmapResult
import com.abhinav.asthetic.utils.fetcher.data.ResponseState
import com.abhinav.asthetic.utils.getFormatedDate
import com.abhinav.asthetic.utils.load
import com.abhinav.asthetic.utils.loadRoundedCorner
import kotlinx.android.synthetic.main.layout_collection_single_item.view.*

/**
 * Created by abhinav.sharma on 08/01/18.
 */
class CollectionsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var rootLayout: View = itemView.rootView
    val list = arrayListOf(202, 404)
    lateinit var projectCoversImageViewModel: ImageViewModel

    fun bind(collection: Collection, listener: (Collection) -> Unit) = with(itemView) {

        if (collection.projectCovers != null && !collection.projectCovers!!.isEmpty()) {
//            iv_collection_1.load(collection.projectCovers!![0].url!!.replace("202", "404")) { requestCreator ->
//                requestCreator.fit().centerCrop()
//            }


            iv_collection_1.setImageBitmap(null)
            projectCoversImageViewModel = ImageViewModel("projects", collection.projectCovers!![0].url!!.substringAfterLast("/"))
            projectCoversImageViewModel.loadImages(list)
            projectCoversImageViewModel.bitmapResult.observeForever {
                it?.let {
                    when (it.state) {
                        ResponseState.LOADING -> {

                        }
                        ResponseState.ERROR -> {

                        }
                        ResponseState.SUCCESS -> {
                            it.bitmap?.let { bitmap ->
                                iv_collection_1.setImageBitmap(bitmap)
                            }
                        }
                    }
                }
            }

            tv_collection_label.text = collection.title
            tv_collection_items.text = collection.stats?.let {
                "Items: " + it.items
            }
            tv_collection_last_updated.text = collection.createdOn?.getFormatedDate()
        }

        if (collection.owners?.isNotEmpty()!! && !collection.owners!![0].displayName.isNullOrBlank()) {
            tv_owner_name.text = collection.owners?.get(0)?.displayName
        } else {
            tv_owner_name.text = collection.owners?.let {
                it[0].username.plus("-username")
            }
        }
        if (collection.owners!!.isNotEmpty()) {
            when {
                !collection.owners!![0].images!!.fullImage.isNullOrBlank() ->
                    iv_owner.loadRoundedCorner(collection.owners?.get(0)?.images?.fullImage!!) { requestCreator ->
                        requestCreator.fit().centerCrop()
                    }

                !collection.owners!![0].images!!.xtraLarge.isNullOrBlank() ->
                    iv_owner.loadRoundedCorner(collection.owners?.get(0)?.images?.xtraLarge!!) { requestCreator ->
                        requestCreator.fit().centerCrop()
                    }
                !collection.owners!![0].images!!.large.isNullOrBlank() ->
                    iv_owner.loadRoundedCorner(collection.owners?.get(0)?.images?.large!!) { requestCreator ->
                        requestCreator.fit().centerCrop()
                    }
                !collection.owners!![0].images!!.medium.isNullOrBlank() ->
                    iv_owner.loadRoundedCorner(collection.owners?.get(0)?.images?.medium!!) { requestCreator ->
                        requestCreator.fit().centerCrop()
                    }
                !collection.owners!![0].images!!.small.isNullOrBlank() ->
                    iv_owner.loadRoundedCorner(collection.owners?.get(0)?.images?.small!!) { requestCreator ->
                        requestCreator.fit().centerCrop()
                    }
                !collection.owners!![0].images!!.xtraSmall.isNullOrBlank() ->
                    iv_owner.loadRoundedCorner(collection.owners?.get(0)?.images?.xtraSmall!!) { requestCreator ->
                        requestCreator.fit().centerCrop()
                    }
            }
        }

        itemView.setOnClickListener { listener(collection) }
    }

    fun onViewDetached() {
        projectCoversImageViewModel.unSubscribe()
    }
}