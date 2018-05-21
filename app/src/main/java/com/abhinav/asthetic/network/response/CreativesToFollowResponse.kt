package com.abhinav.asthetic.network.response

import com.abhinav.asthetic.network.pojo.Owner
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class CreativesToFollowResponse {
    @SerializedName("creatives_to_follow")
    @Expose
    var creativesToFollow: List<Owner>? = null
    @SerializedName("http_code")
    @Expose
    var httpCode: Int = 0
}