package com.abhinav.asthetic.base

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.RelativeLayout
import com.abhinav.asthetic.R
import com.abhinav.asthetic.utils.FailureResponse
import kotlinx.android.synthetic.main.activity_base.*

/**
 * Created by abhinav.sharma on 28/12/17.
 */
abstract class BaseActivity : AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        setLayout()
    }

    private fun setLayout() {
        if (getResourceId() != -1) {
            removeLayout()
            val layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT)
            val view = layoutInflater.inflate(getResourceId(), null)
            base_container.addView(view, layoutParams)
        }
    }

    abstract fun getResourceId(): Int

    private fun removeLayout() {
        if (base_container.childCount >= 1)
            base_container.removeAllViews()
    }

    fun addFragment(fragment: Fragment, layoutResId: Int, tag: String) {
        supportFragmentManager.beginTransaction()
                .add(layoutResId, fragment, tag)
                .commit()
    }

    fun addFragmentWithBackStack(fragment: Fragment, layoutResId: Int, tag: String) {
        supportFragmentManager.beginTransaction()
                .add(layoutResId, fragment, tag)
                .addToBackStack(tag)
                .commit()
    }

    override fun showSnackbar(msg: String) {
        Snackbar.make(base_container, msg, Snackbar.LENGTH_LONG).show()
    }

    override fun showToastLong(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showToastShort(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgressDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgressDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(failureResponse: FailureResponse) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNoNetworkError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}