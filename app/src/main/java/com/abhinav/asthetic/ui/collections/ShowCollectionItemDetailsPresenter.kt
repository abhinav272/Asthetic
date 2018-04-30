package com.abhinav.asthetic.ui.collections

import com.abhinav.asthetic.base.BasePresenter
import com.abhinav.asthetic.network.pojo.Collection
import com.abhinav.asthetic.network.pojo.LatestProject

/**
 * Created by appinventiv on 21/4/18.
 */
class ShowCollectionItemDetailsPresenter(view: ShowCollectionItemDetailsView) : BasePresenter<ShowCollectionItemDetailsView>(view), ShowCollectionItemDetailsModelListener {

    private lateinit var model: ShowCollectionItemDetailsModel
    private lateinit var collectionBase: Collection
    private lateinit var allProjects: List<LatestProject>

    init {
        setModel()
    }

    override fun initView() {
        collectionBase = getView()?.getCollectionBaseFromHost()!!
        if (collectionBase.latestProjects != null)
            allProjects = collectionBase.latestProjects!!

        getView()?.showCollectionDetails(collectionBase)

        model.fetchProjectListByCollectionId(collectionBase.id)
    }
    override fun setModel() {
        model = ShowCollectionItemDetailsModel(this)
    }

    override fun onProjectListLoaded(projectList: List<LatestProject>) {
        getView()?.populateProjectList(projectList)
    }
}