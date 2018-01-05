package com.abhinav.asthetic.base

import com.abhinav.asthetic.utils.FailureResponse

/**
 * Created by abhinav.sharma on 28/12/17.
 */
interface BaseModelListener {
    fun noNetworkError()
    fun commonError(failureResponse: FailureResponse)
}