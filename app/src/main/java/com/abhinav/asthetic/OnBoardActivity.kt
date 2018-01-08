package com.abhinav.asthetic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.abhinav.asthetic.base.BaseActivity
import com.abhinav.asthetic.ui.ShowCollectionFragment
import kotlinx.android.synthetic.main.activity_on_board.*

class OnBoardActivity : BaseActivity() {
    override fun getResourceId(): Int = R.layout.activity_on_board

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(ShowCollectionFragment(), R.id.frame_container, "test")
    }
}
