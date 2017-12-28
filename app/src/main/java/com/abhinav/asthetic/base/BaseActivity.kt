package com.abhinav.asthetic.base

import android.support.v4.app.ActivityCompat
import com.abhinav.asthetic.utils.FailureResponse

/**
 * Created by abhinav.sharma on 28/12/17.
 */
class BaseActivity : ActivityCompat(), BaseView {
    override fun showSnackbar(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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