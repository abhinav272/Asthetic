package com.abhinav.asthetic.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.abhinav.asthetic.R
import com.abhinav.asthetic.adapter.CollectionsAdapter
import com.abhinav.asthetic.base.BaseFragment
import com.abhinav.asthetic.network.pojo.Collection
import kotlinx.android.synthetic.main.fragment_collection.*

/**
 * Created by abhinav.sharma on 30/12/17.
 */
class ShowCollectionFragment : BaseFragment(), ShowCollectionView, (Collection) -> Unit {

    override fun invoke(p1: Collection) {
        Log.e("click on", "${p1.title}")
    }

    private lateinit var presenter: ShowCollectionPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_collection, container, false)
        presenter = ShowCollectionPresenter(this)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.initView()
    }

    override fun populateCollections(collections: List<Collection>) {
        Toast.makeText(activity, "hello", Toast.LENGTH_SHORT).show()
        rv_collections.layoutManager = LinearLayoutManager(context)
        rv_collections.adapter = CollectionsAdapter(this, collections)
    }

    override fun showFooterLoader() {

    }

    override fun hideFooterLoader() {

    }
}