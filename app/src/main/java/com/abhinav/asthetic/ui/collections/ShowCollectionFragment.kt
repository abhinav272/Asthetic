package com.abhinav.asthetic.ui.collections

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.abhinav.asthetic.R
import com.abhinav.asthetic.adapter.CollectionsAdapter
import com.abhinav.asthetic.base.BaseFragment
import com.abhinav.asthetic.network.pojo.Collection
import com.abhinav.asthetic.network.pojo.Owner
import com.abhinav.asthetic.utils.recyclerview_utils.LinearInfiniteScrollListner
import kotlinx.android.synthetic.main.fragment_collection.*

/**
 * Created by abhinav.sharma on 30/12/17.
 */
class ShowCollectionFragment : BaseFragment(), ShowCollectionView, (Collection) -> Unit {

    private var collections: ArrayList<Collection> = ArrayList()
    private lateinit var presenter: ShowCollectionPresenter
    private lateinit var host: CollectionDetailHost

    override fun invoke(p1: Collection) {
        host.onCollectionSelected(p1)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context?.let {
            if (context is CollectionDetailHost) host = context
            else throw IllegalStateException("Host must implement CollectionDetailHost")
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_collection, container, false)
        presenter = ShowCollectionPresenter(this)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_collections.layoutManager = LinearLayoutManager(context)
        rv_collections.adapter = CollectionsAdapter(this, collections)
        rv_collections.addOnScrollListener(LinearInfiniteScrollListner(rv_collections.layoutManager as LinearLayoutManager)
        { presenter.loadMoreCollections() })
        presenter.initView()
    }

    override fun populateCollections(collections: List<Collection>) {
        (rv_collections.adapter as CollectionsAdapter).updateDataSet(collections)
//        runLayoutAnimation(rv_collections)
    }

    private fun runLayoutAnimation(recyclerView: RecyclerView) {
        val context = recyclerView.context
        val controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_from_bottom)
        recyclerView.layoutAnimation = controller
        recyclerView.adapter.notifyDataSetChanged()
        recyclerView.scheduleLayoutAnimation()
    }

    override fun showCreativesList(creativesToFollowList: List<Owner>?) {

    }

    override fun showFooterLoader() {
//        showLoadMoreView()
    }

    override fun hideFooterLoader() {
        Log.e("hide", "footer")
    }
}