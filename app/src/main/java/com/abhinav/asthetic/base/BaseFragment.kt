package com.abhinav.asthetic.base

import android.support.v4.app.Fragment
import com.abhinav.asthetic.utils.FailureResponse

/**
 * Created by abhinav.sharma on 28/12/17.
 */
class BaseFragment: Fragment(), BaseView{

    override fun showSnackbar(msg: String) {

    }

    override fun showToastLong(msg: String) {

    }

    override fun showToastShort(msg: String) {

    }

    override fun showProgressDialog() {

    }

    override fun hideProgressDialog() {

    }

    override fun showError(failureResponse: FailureResponse) {

    }

    override fun showNoNetworkError() {

    }

}