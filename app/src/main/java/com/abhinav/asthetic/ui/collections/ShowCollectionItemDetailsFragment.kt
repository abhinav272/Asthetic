package com.abhinav.asthetic.ui.collections

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abhinav.asthetic.R
import com.abhinav.asthetic.adapter.ProjectsAdapter
import com.abhinav.asthetic.base.BaseFragment
import com.abhinav.asthetic.network.pojo.Collection
import com.abhinav.asthetic.network.pojo.LatestProject
import kotlinx.android.synthetic.main.fragment_collection_details.*

/**
 * Created by appinventiv on 19/4/18.
 */
class ShowCollectionItemDetailsFragment : BaseFragment(), ShowCollectionItemDetailsView, (LatestProject) -> Unit {

    private lateinit var presenter: ShowCollectionItemDetailsPresenter
    private lateinit var adapter: ProjectsAdapter
    private lateinit var host: CollectionItemDetailHost

    override fun getCollectionBaseFromHost(): Collection = host.getCollection()

    /**
     * Fail-Fast approach for host
     * */
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context?.let {
            if (context is CollectionItemDetailHost) host = context
            else throw IllegalStateException("Host must implement CollectionItemDetailHost")
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_collection_details, container, false)
        presenter = ShowCollectionItemDetailsPresenter(this)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        presenter.initView()
    }

    private fun initViews() {
        adapter = ProjectsAdapter(this)
        rv_projects.adapter = adapter
        val gridLayoutManager = GridLayoutManager(context, 2)
        rv_projects.layoutManager = gridLayoutManager
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int = when (adapter.getItemViewType(position)) {
                adapter.TYPE_HEADER -> 2
                adapter.TYPE_ITEM -> 1
                else -> -1
            }
        }
    }

    override fun showCollectionDetails(collection: Collection) {
        Log.e("yo ShowCollectionBase", collection.title + collection.latestProjects?.size)
        collection.latestProjects?.let { adapter.rePopulateProjects(it) }
    }

    override fun populateProjectList(projectList: List<LatestProject>) {
        Log.e("yo PopulateList", "" + projectList.size)
        adapter.populateProjects(projectList)
    }

    override fun invoke(p1: LatestProject) {
        Log.e("yo", p1.name)
    }

}
