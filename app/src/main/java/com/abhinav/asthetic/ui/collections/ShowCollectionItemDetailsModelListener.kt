package com.abhinav.asthetic.ui.collections

import com.abhinav.asthetic.base.BaseModelListener
import com.abhinav.asthetic.network.pojo.LatestProject

interface ShowCollectionItemDetailsModelListener: BaseModelListener {
    fun onProjectListLoaded(projectList: List<LatestProject>)
}
