package com.abhinav.asthetic.network

import com.abhinav.asthetic.utils.FailureResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by abhinav.sharma on 28/12/17.
 */
abstract class NetworkResponse<T>(private var handler: NoNetworkHandler) : Callback<T> {
    abstract fun onSuccess(body: T?)
    abstract fun onFailure(failureResponse: FailureResponse)
    abstract fun onError(t: Throwable)

    override fun onFailure(call: Call<T>?, t: Throwable?) {
        t?.let {
            if (it is SocketTimeoutException || it is UnknownHostException)
                handler.onNetworkError()
            else
                onError(it)
        }
    }

    override fun onResponse(call: Call<T>?, response: Response<T>?) {
        if (response != null && response.isSuccessful) {
            if (response.isSuccessful)
                onSuccess(response.body())
            else {
                /**
                 * change @param message as per API docs
                 */
                onFailure(FailureResponse(response.message(), response.code()))
            }
        }
    }
}