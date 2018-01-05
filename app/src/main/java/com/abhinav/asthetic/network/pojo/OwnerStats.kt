package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by abhinav.sharma on 29/12/17.
 */
class OwnerStats {
    @SerializedName("followers")
    @Expose
    var followers: Int = 0
    @SerializedName("following")
    @Expose
    var following: Int = 0
    @SerializedName("appreciations")
    @Expose
    var appreciations: Int = 0
    @SerializedName("views")
    @Expose
    var views: Int = 0
    @SerializedName("comments")
    @Expose
    var comments: Int = 0
}