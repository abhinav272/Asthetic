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

    init {
        setModel()
    }

    override fun initView() {
        collectionBase = getView()?.getCollectionBaseFromHost()!!
        getView()?.showCollectionDetails(collectionBase)
    }
    override fun setModel() {
        model = ShowCollectionItemDetailsModel(this)
    }

    override fun onProjectListLoaded(projectList: List<LatestProject>) {
        getView()?.populateProjectList(projectList)
    }
}