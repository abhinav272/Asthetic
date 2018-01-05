package com.abhinav.asthetic.base

import android.util.Log
import com.abhinav.asthetic.R
import com.abhinav.asthetic.network.NoNetworkHandler
import com.abhinav.asthetic.utils.FailureResponse
import com.abhinav.asthetic.utils.ResourceUtil
import io.reactivex.Observer
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by abhinav.sharma on 28/12/17.
 */
abstract class BaseModel<T>(private val listener: BaseModelListener) : NoNetworkHandler, Observer<T> {

    override fun onError(e: Throwable?) {
        e?.let {
            Log.e("Crash", "${e.printStackTrace()}")
            if (it is SocketTimeoutException || it is UnknownHostException)
                onNetworkError()
            else
                onCommonError(it)
        }
    }

    private fun onCommonError(t: Throwable) {
        val failureResponse = FailureResponse()
        if (t is HttpException) {
            failureResponse.errorCode = t.code()
            when (t.code()) {
                403 -> failureResponse.errorMessage = ResourceUtil.getString(R.string.error_403)
                404 -> failureResponse.errorMessage = ResourceUtil.getString(R.string.error_404)
                429 -> failureResponse.errorMessage = ResourceUtil.getString(R.string.error_429)
                500 -> failureResponse.errorMessage = ResourceUtil.getString(R.string.error_500)
                503 -> failureResponse.errorMessage = ResourceUtil.getString(R.string.error_503)
            }
        }
        listener.commonError(failureResponse)
    }


    override fun onNetworkError() {
        listener.noNetworkError()
    }

    abstract fun destroy()
}