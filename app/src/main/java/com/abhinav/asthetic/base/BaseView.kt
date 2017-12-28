package com.abhinav.asthetic.base

import com.abhinav.asthetic.utils.FailureResponse

/**
 * Created by abhinav.sharma on 27/12/17.
 */
interface BaseView {
    /**
     * show message on view
     * @param msg
     */
    fun showSnackbar(msg: String)

    fun showToastLong(msg: String)

    fun showToastShort(msg: String)

    fun showProgressDialog()

    fun hideProgressDialog()

    /**
     * perform UI action on data failure response
     * @param failureResponse
     */
    fun showError(failureResponse: FailureResponse)

    fun showNoNetworkError()
}