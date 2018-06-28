package com.abhinav.asthetic.network

import com.abhinav.asthetic.BuildConfig
import com.abhinav.asthetic.network.response.CollectionsResponse
import com.abhinav.asthetic.network.response.CreativesToFollowResponse
import com.abhinav.asthetic.network.response.ProjectDetailsResponse
import com.abhinav.asthetic.network.response.ProjectListResponse
import com.abhinav.asthetic.utils.EpochTimeAdapter
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Streaming
import java.util.*
import java.util.concurrent.TimeUnit


/**
 * Created by abhinav.sharma on 28/12/17.
 */
interface APIInterface {
    companion object {
        val BEHANCE_BASE_URL = "https://api.behance.net"

        fun getAPIService(): APIInterface {
            return Retrofit.Builder()
                    .baseUrl(BEHANCE_BASE_URL)
                    .addConverterFactory(getGsonConverterFactory())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                    .client(getClient())
                    .build()
                    .create(APIInterface::class.java)
        }

        private fun getClient(): OkHttpClient {
            val httpClient = OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = when {
                            BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
                            else -> HttpLoggingInterceptor.Level.NONE
                        }
                    })
                    .addInterceptor { chain ->
                        val original = chain.request()
                        val originalHttpUrl = original.url()

                        val url = originalHttpUrl.newBuilder()
                                .addQueryParameter("api_key", BuildConfig.API_KEY)
//                                .addQueryParameter("api_key", "io")
                                .build()

                        // Request customization: add request headers
                        val requestBuilder = original.newBuilder()
                                .url(url)

                        val request = requestBuilder.build()
                        chain.proceed(request)
                    }
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
            return httpClient.build()
        }

        private fun getGsonConverterFactory(): GsonConverterFactory {
            val gson = GsonBuilder().registerTypeAdapter(Date::class.java, EpochTimeAdapter.epochTimeAdapter).create()
            return GsonConverterFactory.create(gson)
        }
    }

    @Streaming
    @GET("/v2/collections")
    fun getBaseCollections(@Query("page") page: Int): Observable<CollectionsResponse>

    @GET("/v2/collections")
    fun getCollectionsByQuery(@Query("q") query: String, @Query("page") page: Int): Call<Single<CollectionsResponse>>

    @GET("/v2/collections/{collectionId}/projects")
    fun getAllProjectsByCollectionId(@Path("collectionId") collectionId: Int): Observable<ProjectListResponse>

    @GET("/v2/creativestofollow")
    fun getCreativesToFollow(): Observable<CreativesToFollowResponse>

    @GET("/v2/projects/{projectId}")
    fun getProjectDetailsById(@Path("projectId") projectId: Int): Observable<ProjectDetailsResponse>

}