package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by abhinav.sharma on 29/12/17.
 */
class CollectionStats {
    @SerializedName("items")
    @Expose
    var items: Int = 0
    @SerializedName("followers")
    @Expose
    var followers: Int = 0
}