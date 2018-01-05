package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by abhinav.sharma on 29/12/17.
 */
class CollectionCover {
    @SerializedName("url")
    @Expose
    var url: String? = null
}