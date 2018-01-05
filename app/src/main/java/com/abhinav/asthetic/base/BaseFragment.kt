package com.abhinav.asthetic.base

import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.widget.Toast
import com.abhinav.asthetic.R
import com.abhinav.asthetic.utils.FailureResponse
import com.abhinav.asthetic.utils.ResourceUtil

/**
 * Created by abhinav.sharma on 28/12/17.
 */
open class BaseFragment: Fragment(), BaseView{

    override fun showSnackbar(msg: String) {
        (activity as BaseActivity).showSnackbar(msg)
    }

    override fun showToastLong(msg: String) {

    }

    override fun showToastShort(msg: String) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showProgressDialog() {

    }

    override fun hideProgressDialog() {

    }

    override fun showError(failureResponse: FailureResponse) {
        showSnackbar(failureResponse.errorMessage)
    }

    override fun showNoNetworkError() {
        showSnackbar(ResourceUtil.getString(R.string.no_network_string))
    }

}