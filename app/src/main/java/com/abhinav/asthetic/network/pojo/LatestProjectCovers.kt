package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by abhinav.sharma on 29/12/17.
 */
class LatestProjectCovers {

    @SerializedName("115")
    @Expose
    var small: String? = null
    @SerializedName("202")
    @Expose
    var medium: String? = null
    @SerializedName("230")
    @Expose
    var large: String? = null
    @SerializedName("404")
    @Expose
    var xtraLarge: String? = null
    @SerializedName("original")
    @Expose
    var original: String? = null

}