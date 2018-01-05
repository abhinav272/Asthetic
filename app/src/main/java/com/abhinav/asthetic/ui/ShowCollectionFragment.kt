package com.abhinav.asthetic.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.abhinav.asthetic.R
import com.abhinav.asthetic.base.BaseFragment
import com.abhinav.asthetic.network.pojo.Collection
import kotlinx.android.synthetic.main.fragment_collection.*

/**
 * Created by abhinav.sharma on 30/12/17.
 */
class ShowCollectionFragment : BaseFragment(), ShowCollectionView {

    private lateinit var presenter: ShowCollectionPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_collection, container, false)
        presenter = ShowCollectionPresenter(this)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        button.setOnClickListener {
//            val apiService = APIInterface.getAPIService()
//            apiService.getBaseCollections(1)
//                    .observeOn(AndroidSchedulers.mainThread())
////                    .subscribe { Log.e("againtest", "${it.collections?.size} and ${it.httpCode}") }
//                    .subscribe(
//                            {t-> Log.e("tessting", "${t.collections?.size}")},
//                            {t2 -> Log.e("yofail", t2.message)}
//                    )
//        }

        button.setOnClickListener {
            presenter.initView()
        }

    }

    override fun populateCollections(collections: List<Collection>) {
        Toast.makeText(activity, "hello", Toast.LENGTH_SHORT).show()
    }

    override fun showFooterLoader() {

    }

    override fun hideFooterLoader() {

    }
}