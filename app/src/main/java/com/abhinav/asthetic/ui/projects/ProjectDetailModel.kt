package com.abhinav.asthetic.ui.projects

import com.abhinav.asthetic.base.BaseModel
import com.abhinav.asthetic.network.APIInterface
import com.abhinav.asthetic.network.response.ProjectDetailsResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class ProjectDetailModel(private val listener: ProjectDetailModelListener) : BaseModel<ProjectDetailsResponse>(listener) {

    fun fetchProjectDetails(projectId: Int) {
        APIInterface.getAPIService().getProjectDetailsById(projectId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this)
    }


    override fun onComplete() {
        disposable.clear()
    }


    override fun destroy() {
        when {
            !disposable.isDisposed -> disposable.dispose()
        }
    }

    private var disposable = CompositeDisposable()

    override fun onSubscribe(d: Disposable) {
        disposable.add(d)
    }

    override fun onNext(value: ProjectDetailsResponse) {
        value.projectDetail?.let {
            listener.onProjectDetailsFetched(it)
        }
    }
}