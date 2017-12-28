package com.abhinav.asthetic.network

import com.abhinav.asthetic.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


/**
 * Created by abhinav.sharma on 28/12/17.
 */
interface APIInterface {
    companion object {
        val BEHANCE_BASE_URL = "https://api.behance.net/v2/"

        fun getAPIService(): APIInterface {
            return Retrofit.Builder()
                    .baseUrl(BEHANCE_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getClient())
                    .build()
                    .create(APIInterface::class.java)
        }

        private fun getClient(): OkHttpClient {
            val httpClient = OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        val original = chain.request()
                        val originalHttpUrl = original.url()

                        val url = originalHttpUrl.newBuilder()
                                .addQueryParameter("api_key", BuildConfig.API_KEY)
                                .build()

                        // Request customization: add request headers
                        val requestBuilder = original.newBuilder()
                                .url(url)

                        val request = requestBuilder.build()
                        chain.proceed(request)
                    }
            return httpClient.build()
        }
    }

    @GET("collections")
    fun getBaseCollections()
}