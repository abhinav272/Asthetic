package com.abhinav.asthetic.utils.fetcher

import com.abhinav.asthetic.utils.fetcher.data.BitmapWithQuality
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Paulina Sadowska on 03.07.2018.
 */
class ImageFetcher(private val picasso: Picasso) {

    fun loadProgressively(baseUrl: String, qualities: List<Int>, type: String, uniqueKey: String): Observable<BitmapWithQuality> {
        return qualities
                .map { quality -> Pair(createUrl(baseUrl, type, quality, uniqueKey), quality) }
                .map { loadImageAndIgnoreError(it) }
                .reduce { o1, o2 -> Observable.merge(o1, o2) }
    }

    fun loadProgressively(baseUrl: String, quality1: Int, quality2: Int, type: String, uniqueKey: String): Observable<BitmapWithQuality> {
        return Observable.merge(
                loadImageAndIgnoreError(createUrl(baseUrl, type, quality1, uniqueKey), quality1),
                loadImageAndIgnoreError(createUrl(baseUrl, type, quality2, uniqueKey), quality2)
        )
    }

    private fun loadImageAndIgnoreError(urlWithQuality: Pair<String, Int>): Observable<BitmapWithQuality> {
        val (url, quality) = urlWithQuality
        return loadImageAndIgnoreError(url, quality)
    }

    private fun loadImageAndIgnoreError(url: String, quality: Int): Observable<BitmapWithQuality> {
        return Single
                .create(ImageFetcherSingleSubscribe(picasso, url, quality))
                .toObservable()
                .onErrorResumeNext(Observable.empty<BitmapWithQuality>())
    }

    private fun createUrl(url: String, type: String, size: Int, uniqueKey: String): String = "$url/$type/$size/$uniqueKey" //?image=0 added so image wont be random
}

