package com.abhinav.asthetic

import android.os.Bundle
import com.abhinav.asthetic.base.BaseActivity
import com.abhinav.asthetic.network.pojo.Collection
import com.abhinav.asthetic.network.pojo.LatestProject
import com.abhinav.asthetic.ui.collections.CollectionDetailHost
import com.abhinav.asthetic.ui.collections.CollectionItemDetailHost
import com.abhinav.asthetic.ui.collections.ShowCollectionFragment
import com.abhinav.asthetic.ui.collections.ShowCollectionItemDetailsFragment
import com.abhinav.asthetic.ui.projects.ProjectDetailFragment

class OnBoardActivity : BaseActivity(), CollectionDetailHost, CollectionItemDetailHost {

    private lateinit var collection: Collection
    override fun getResourceId(): Int = R.layout.activity_on_board

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showCollectionFragment()
    }

    fun showCollectionFragment() {
        addFragment(ShowCollectionFragment(), R.id.frame_container, ShowCollectionFragment::class.java.simpleName)
    }

    fun showCollectionDetailFragment() {
        addFragmentWithBackStack(ShowCollectionItemDetailsFragment(), R.id.frame_container, ShowCollectionItemDetailsFragment::class.java.simpleName)
    }

    override fun onCollectionSelected(collection: Collection) {
        this.collection = collection
        showCollectionDetailFragment()
    }

    override fun getCollection(): Collection = collection

    override fun showProjectDetails(project: LatestProject) {
        addFragmentWithBackStack(ProjectDetailFragment.getInstance(project.id), R.id.frame_container, ProjectDetailFragment::class.java.simpleName)
    }
}
