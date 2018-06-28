package com.abhinav.asthetic.ui.collections

import com.abhinav.asthetic.base.BaseView
import com.abhinav.asthetic.network.pojo.Collection
import com.abhinav.asthetic.network.pojo.LatestProject

/**
 * Created by appinventiv on 19/4/18.
 */
interface ShowCollectionItemDetailsView: BaseView {

    fun showCollectionDetails(collection: Collection)
    fun populateProjectList(projectList: List<LatestProject>)
    fun getCollectionBaseFromHost():Collection
    fun showProjectDetails(project: LatestProject)

}