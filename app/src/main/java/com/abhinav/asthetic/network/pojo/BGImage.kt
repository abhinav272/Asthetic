package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class BGImage {
    @SerializedName("repeat")
    @Expose
    var repeat: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("position")
    @Expose
    var position: String? = null
}