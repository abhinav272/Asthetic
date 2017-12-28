package com.abhinav.asthetic.base

import com.abhinav.asthetic.network.NoNetworkHandler

/**
 * Created by abhinav.sharma on 28/12/17.
 */
class BaseModel(private val listener: BaseModelListener): NoNetworkHandler {


    override fun onNetworkError() {
        listener.noNetworkError()
    }
}