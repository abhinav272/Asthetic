package com.abhinav.asthetic.ui.projects

import com.abhinav.asthetic.base.BasePresenter
import com.abhinav.asthetic.network.pojo.ProjectDetail

class ProjectDetailPresenter(view: ProjectDetailView) : BasePresenter<ProjectDetailView>(view), ProjectDetailModelListener {

    private lateinit var model: ProjectDetailModel
    private lateinit var projectDetail: ProjectDetail

    init {
        setModel()
    }


    override fun initView() {
        val projectId = getView()?.getProjectId()
        projectId?.let { model.fetchProjectDetails(it) }
    }

    override fun setModel() {
        model = ProjectDetailModel(this)
    }

    override fun onProjectDetailsFetched(projectDetail: ProjectDetail) {
        this.projectDetail = projectDetail
        getView()?.populateProjectDetails(projectDetail)
    }
}