package com.abhinav.asthetic.utils.recyclerview_utils

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

/**
 * Created by abhinav.sharma on 17/01/18.
 */
class LinearInfiniteScrollListner(private val linearLayoutManager: LinearLayoutManager,
                                  private val func: () -> Unit) : RecyclerView.OnScrollListener() {

    private var previousTotal = 0
    private var loading = true
    private var visibleThreshold = 2
    private var firstVisibleItem = 0
    private var visibleItemCount = 0
    private var totalItemCount = 0

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        if (dy > 0) {
            visibleItemCount = recyclerView?.childCount!!
            totalItemCount = linearLayoutManager.itemCount
            firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition()

            if (loading) {
                if (totalItemCount > previousTotal) {
                    loading = false
                    previousTotal = totalItemCount;
                }
            }
            if (!loading && (totalItemCount - visibleItemCount)
                    <= (firstVisibleItem + visibleThreshold)) {
                Log.e("InfiniteScrollListener", "End reached")
                func()
                loading = true
            }
        }
    }
}