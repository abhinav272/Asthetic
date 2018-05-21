package com.abhinav.asthetic.ui.collections

import com.abhinav.asthetic.base.BaseModel
import com.abhinav.asthetic.network.APIInterface
import com.abhinav.asthetic.network.pojo.Owner
import com.abhinav.asthetic.network.response.CollectionsResponse
import com.abhinav.asthetic.network.response.CreativesToFollowResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by abhinav.sharma on 04/01/18.
 */
class ShowCollectionModel(private val listener: ShowCollectionModelListener) : BaseModel<CollectionsResponse>(listener) {


    public fun fetchCollections(page: Int) {
        APIInterface.getAPIService().getBaseCollections(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this)
    }

    fun fetchCreativesToFollow() {
        APIInterface.getAPIService().getCreativesToFollow()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onSubscribe(it) }
                .subscribe({ t: CreativesToFollowResponse -> onCreativesFetched(t.creativesToFollow) },
                        { t: Throwable? -> onError(t) })
    }

    private fun onCreativesFetched(creativesToFollowList: List<Owner>?) {
        listener.onCreativesToFollowLoaded(creativesToFollowList)
    }

    override fun onNext(value: CollectionsResponse?) {
        value?.let {
            listener.onCollectionsLoaded(it.collections)
        }
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
}