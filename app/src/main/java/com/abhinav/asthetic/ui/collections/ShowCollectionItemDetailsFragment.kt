package com.abhinav.asthetic.ui.collections

import com.abhinav.asthetic.base.BaseFragment
import com.abhinav.asthetic.network.pojo.Collection
import com.abhinav.asthetic.network.pojo.LatestProject

/**
 * Created by appinventiv on 19/4/18.
 */
class ShowCollectionItemDetailsFragment: BaseFragment(), ShowCollectionItemDetailsView {


    var host: CollectionItemDetailHost? = null

    override fun getCollectionBaseFromHost(): Collection {
        if (host == null)
            throw IllegalStateException("Host must implement CollectionItemDetailHost")
        return host?.getCollection()!!
    }

    override fun showCollectionDetails(collection: Collection) {

    }

    override fun populateProjectList(projectList: List<LatestProject>) {

    }

}
