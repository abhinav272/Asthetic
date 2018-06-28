package com.abhinav.asthetic.ui.projects

import com.abhinav.asthetic.base.BaseModelListener
import com.abhinav.asthetic.network.pojo.ProjectDetail

interface ProjectDetailModelListener : BaseModelListener {
    fun onProjectDetailsFetched(projectDetail: ProjectDetail)
}
