package com.abhinav.asthetic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.abhinav.asthetic.base.BaseActivity
import com.abhinav.asthetic.ui.ShowCollectionFragment
import kotlinx.android.synthetic.main.activity_on_board.*

class OnBoardActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_board)
        addFragment(ShowCollectionFragment(), R.id.frame_container, "test")
    }
}
