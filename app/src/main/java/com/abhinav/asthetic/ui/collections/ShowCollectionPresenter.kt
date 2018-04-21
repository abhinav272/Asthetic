package com.abhinav.asthetic.ui

import com.abhinav.asthetic.base.BasePresenter
import com.abhinav.asthetic.network.pojo.Collection

/**
 * Created by abhinav.sharma on 04/01/18.
 */
class ShowCollectionPresenter(view: ShowCollectionView) : BasePresenter<ShowCollectionView>(view), ShowCollectionModelListener {

    private var page: Int = 1
    private lateinit var model: ShowCollectionModel

    init {
        setModel()
    }

    override fun initView() {
        model.fetchCollections(page)
    }

    override fun destroy() {
        super.destroy()
        model.destroy()
    }

    override fun setModel() {
        model = ShowCollectionModel(this)
    }

    fun loadMoreCollections() {
        getView()?.let {
            it.showFooterLoader()
            page++
            model.fetchCollections(page)
        }
    }

    override fun onCollectionsLoaded(collections: List<Collection>?) {
        getView()?.hideFooterLoader()
        collections?.let {
            getView()?.populateCollections(it)
        }
    }
}