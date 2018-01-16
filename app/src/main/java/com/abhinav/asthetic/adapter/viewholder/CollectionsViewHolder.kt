package com.abhinav.asthetic.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.abhinav.asthetic.network.pojo.Collection
import com.abhinav.asthetic.utils.load
import com.abhinav.asthetic.utils.loadCircular
import com.abhinav.asthetic.utils.loadRoundedCorner
import com.abhinav.asthetic.utils.picasso_utils.RoundedCornersTransformation
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.layout_collection_single_item.view.*
import java.util.concurrent.TimeUnit

/**
 * Created by abhinav.sharma on 08/01/18.
 */
class CollectionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(collection: Collection, listener: (Collection) -> Unit) = with(itemView) {
        //        iv_collection.layoutParams.height = collection.height

        if (collection.projectCovers != null && !collection.projectCovers!!.isEmpty()) {
            iv_collection_1.load(collection.projectCovers!![0].url!!) { requestCreator ->
                requestCreator.fit().centerCrop()
            }
//
//            if (collection.projectCovers!!.size > 1)
//                iv_collection_2.load(collection.projectCovers!![1].url!!) { requestCreator ->
//                    requestCreator.fit().centerCrop()
//                }
//
//            if (collection.projectCovers!!.size > 2)
//                iv_collection_3.load(collection.projectCovers!![2].url!!) { requestCreator ->
//                    requestCreator.fit().centerCrop()
//                }
//
//            if (collection.projectCovers!!.size > 3)
//                iv_collection_4.load(collection.projectCovers!![3].url!!) { requestCreator ->
//                    requestCreator.fit().centerCrop()
//                }
//            Observable.interval(2, TimeUnit.SECONDS)
//                    .repeat()
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe { t: Long? ->
//                        if (collection.projectCovers!!.size > t!!) {
//                            iv_collection.load(collection.projectCovers!![t.toInt()].url!!) { requestCreator ->
//                                requestCreator.fit().centerCrop()
//                            }
//                        }
//                    }
        }

        tv_owner_name.text = collection.owners?.get(0)?.displayName
        if (collection.owners!!.isNotEmpty()) {
            when {
                !collection.owners!![0].images!!.fullImage.isNullOrBlank() ->
                    iv_owner.loadCircular(collection.owners?.get(0)?.images?.fullImage!!) { requestCreator ->
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
    }
}