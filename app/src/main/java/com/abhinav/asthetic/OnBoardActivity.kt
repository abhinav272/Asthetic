package com.abhinav.asthetic

import android.os.Bundle
import com.abhinav.asthetic.base.BaseActivity
import com.abhinav.asthetic.ui.ShowCollectionFragment
import com.abhinav.asthetic.ui.collections.ShowCollectionItemDetailsFragment

class OnBoardActivity : BaseActivity() {
    override fun getResourceId(): Int = R.layout.activity_on_board

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showCollectionFragment()
    }

    fun showCollectionFragment() {
        addFragment(ShowCollectionFragment(), R.id.frame_container, "ShowCollectionFragment")
    }

    fun showCollectionDetailFragment() {
        addFragment(ShowCollectionItemDetailsFragment(), R.id.frame_container, "ShowCollectionItemDetailsFragment")
    }
}
