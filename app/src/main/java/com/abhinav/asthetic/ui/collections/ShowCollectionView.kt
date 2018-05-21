package com.abhinav.asthetic.ui.collections

import com.abhinav.asthetic.base.BaseView
import com.abhinav.asthetic.network.pojo.Collection
import com.abhinav.asthetic.network.pojo.Owner

/**
 * Created by abhinav.sharma on 30/12/17.
 */
interface ShowCollectionView : BaseView {
    fun populateCollections(collections: List<Collection>)
    fun showFooterLoader()
    fun hideFooterLoader()
    fun showCreativesList(creativesToFollowList: List<Owner>?)
}