package com.abhinav.asthetic.ui

import com.abhinav.asthetic.base.BaseView
import com.abhinav.asthetic.network.pojo.Collection

/**
 * Created by abhinav.sharma on 30/12/17.
 */
interface ShowCollectionView: BaseView {
    fun populateCollections(collections: List<Collection>)
    fun showFooterLoader()
    fun hideFooterLoader()
}