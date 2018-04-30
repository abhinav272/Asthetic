package com.abhinav.asthetic.ui.collections

import com.abhinav.asthetic.network.pojo.Collection

/**
 * Created by appinventiv on 30/4/18.
 */
interface CollectionDetailHost {
    fun onCollectionSelected(collection: Collection)
}