package com.abhinav.asthetic.network.response

import com.abhinav.asthetic.network.pojo.LatestProject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by appinventiv on 21/4/18.
 */
class ProjectListResponse {
    @SerializedName("projects")
    @Expose
    var projects: List<LatestProject>? = null
    @SerializedName("http_code")
    @Expose
    var httpCode: Int = 0
}