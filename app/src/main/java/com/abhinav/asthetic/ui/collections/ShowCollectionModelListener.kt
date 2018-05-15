package com.abhinav.asthetic.ui.collections

import com.abhinav.asthetic.base.BaseModelListener
import com.abhinav.asthetic.network.pojo.Collection

/**
 * Created by abhinav.sharma on 05/01/18.
 */
interface ShowCollectionModelListener: BaseModelListener {
    fun onCollectionsLoaded(collections: List<Collection>?)
}