package com.abhinav.asthetic.network.response

import com.abhinav.asthetic.network.pojo.Collection
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by abhinav.sharma on 30/12/17.
 */
class CollectionsResponse {
    @SerializedName("collections")
    @Expose
    var collections: List<Collection>? = null
    @SerializedName("http_code")
    @Expose
    var httpCode: Int = 0
}