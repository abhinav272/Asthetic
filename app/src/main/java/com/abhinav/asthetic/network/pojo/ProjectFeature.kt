package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ProjectFeature {
    @SerializedName("featured_on")
    @Expose
    val featuredOn: Int = 0
    @SerializedName("site")
    @Expose
    val site: Site? = null
    @SerializedName("url")
    @Expose
    val url: String? = null
}