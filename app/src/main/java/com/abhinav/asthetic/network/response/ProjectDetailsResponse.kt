package com.abhinav.asthetic.network.response

import com.abhinav.asthetic.network.pojo.ProjectDetail
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProjectDetailsResponse {
    @SerializedName("project")
    @Expose
    var projectDetail: ProjectDetail? = null
    @SerializedName("http_code")
    @Expose
    var httpCode: Int = 0
}