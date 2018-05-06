package com.abhinav.asthetic.ui.collections

import com.abhinav.asthetic.base.BaseModel
import com.abhinav.asthetic.network.APIInterface
import com.abhinav.asthetic.network.pojo.LatestProject
import com.abhinav.asthetic.network.response.ProjectListResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by appinventiv on 21/4/18.
 */
class ShowCollectionItemDetailsModel(private var listener: ShowCollectionItemDetailsModelListener) : BaseModel<ProjectListResponse>(listener) {

    fun fetchProjectListByCollectionId(collectionId: Int) {
        APIInterface.getAPIService()
                .getAllProjectsByCollectionId(collectionId)
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

    override fun onSubscribe(d: Disposable?) {
        disposable.add(d)
    }

    override fun onNext(value: ProjectListResponse?) {
        var list = ArrayList<LatestProject>()
        value?.projects?.let {
            list.addAll(it.filter {
                !allProjects.contains(it)
            })
        }
        listener.onProjectListLoaded(list)
    }

    private lateinit var allProjects: List<LatestProject>

    fun setInitialList(allProjects: List<LatestProject>) {
        this.allProjects = allProjects
    }
}