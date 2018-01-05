package com.abhinav.asthetic.base

import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.abhinav.asthetic.utils.FailureResponse

/**
 * Created by abhinav.sharma on 28/12/17.
 */
open class BaseActivity : AppCompatActivity(), BaseView {

    fun addFragment(fragment: Fragment, layoutResId: Int, tag : String) {
        supportFragmentManager.beginTransaction()
                .add(layoutResId, fragment, tag)
                .commit()
    }

    fun addFragmentWithBackStack(fragment: Fragment, layoutResId: Int, tag: String){
        supportFragmentManager.beginTransaction()
                .add(layoutResId, fragment, tag)
                .addToBackStack(tag)
                .commit()
    }

    override fun showSnackbar(msg: String) {
        Snackbar.make(window.decorView.rootView, msg, Snackbar.LENGTH_LONG).show()
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