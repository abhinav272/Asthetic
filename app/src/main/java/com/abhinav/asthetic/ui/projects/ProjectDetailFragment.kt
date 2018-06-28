package com.abhinav.asthetic.ui.projects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abhinav.asthetic.R
import com.abhinav.asthetic.base.BaseFragment
import com.abhinav.asthetic.network.pojo.ProjectDetail

class ProjectDetailFragment : BaseFragment(), ProjectDetailView {

    private lateinit var presenter: ProjectDetailPresenter
    private var projectId: Int = -1

    companion object {

        private const val SELECTED_PROJECT_ID = "project"

        fun getInstance(projectId: Int): ProjectDetailFragment {
            val args = Bundle()
            args.putInt(SELECTED_PROJECT_ID, projectId)
            val fragment = ProjectDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun getProjectId(): Int {
        return projectId
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_project_detail, container, false)
        presenter = ProjectDetailPresenter(this)
        projectId = arguments.getInt(SELECTED_PROJECT_ID, -1)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.initView()
    }

    override fun populateProjectDetails(projectDetail: ProjectDetail) {

    }
}