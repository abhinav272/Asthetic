package com.abhinav.asthetic.ui.collections

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abhinav.asthetic.R
import com.abhinav.asthetic.adapter.ProjectsAdapter
import com.abhinav.asthetic.base.BaseFragment
import com.abhinav.asthetic.network.pojo.Collection
import com.abhinav.asthetic.network.pojo.LatestProject

/**
 * Created by appinventiv on 19/4/18.
 */
class ShowCollectionItemDetailsFragment : BaseFragment(), ShowCollectionItemDetailsView, (LatestProject) -> Unit {

    private lateinit var presenter: ShowCollectionItemDetailsPresenter
    private lateinit var adapter: ProjectsAdapter
    var host: CollectionItemDetailHost? = null

    override fun getCollectionBaseFromHost(): Collection {
        if (host == null)
            throw IllegalStateException("Host must implement CollectionItemDetailHost")
        return host!!.getCollection()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_collection_details, container, false)
        presenter = ShowCollectionItemDetailsPresenter(this)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        adapter = ProjectsAdapter(this)
    }

    override fun showCollectionDetails(collection: Collection) {
        collection.latestProjects?.let { adapter.rePopulateProjects(it) }
    }

    override fun populateProjectList(projectList: List<LatestProject>) {
        adapter.populateProjects(projectList)
    }

    override fun invoke(p1: LatestProject) {
        Log.e("yo", p1.name)
    }

}
