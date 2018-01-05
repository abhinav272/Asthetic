package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by abhinav.sharma on 29/12/17.
 */
class LatestProject {

    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("published_on")
    @Expose
    var publishedOn: Int = 0
    @SerializedName("created_on")
    @Expose
    var createdOn: Int = 0
    @SerializedName("modified_on")
    @Expose
    var modifiedOn: Int = 0
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("privacy")
    @Expose
    var privacy: String? = null
    @SerializedName("fields")
    @Expose
    var fields: List<String>? = null
    @SerializedName("covers")
    @Expose
    var covers: LatestProjectCovers? = null
    @SerializedName("mature_content")
    @Expose
    var matureContent: Int = 0
    @SerializedName("mature_access")
    @Expose
    var matureAccess: String? = null
    @SerializedName("owners")
    @Expose
    var owners: List<Owner>? = null
    @SerializedName("stats")
    @Expose
    var stats: LatestProjectStats? = null
    @SerializedName("conceived_on")
    @Expose
    var conceivedOn: Int = 0

}