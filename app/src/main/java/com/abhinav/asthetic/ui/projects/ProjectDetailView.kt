package com.abhinav.asthetic.ui.projects

import com.abhinav.asthetic.base.BaseView
import com.abhinav.asthetic.network.pojo.ProjectDetail

interface ProjectDetailView : BaseView {
    fun getProjectId(): Int
    fun populateProjectDetails(projectDetail: ProjectDetail)
}