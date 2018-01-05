package com.abhinav.asthetic.base

import com.abhinav.asthetic.utils.FailureResponse
import java.lang.ref.SoftReference

/**
 * Created by abhinav.sharma on 27/12/17.
 */
abstract class BasePresenter<T : BaseView> : BaseModelListener {

    private var view: SoftReference<T>?

    constructor(view: T) {
        this.view = SoftReference<T>(view)
    }

    public fun getView(): T? {
        return view?.get()
    }

    abstract fun initView()

    abstract fun setModel()

    fun destroy() {
        view = null
    }

    override fun noNetworkError() {
        getView()?.let { it.showNoNetworkError() }
    }

    override fun commonError(failureResponse: FailureResponse) {
        getView()?.let { it.showError(failureResponse) }
    }
}