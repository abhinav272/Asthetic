package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by abhinav.sharma on 29/12/17.
 */
class OwnerImages {
    @SerializedName("50")
    @Expose
    var xtraSmall: String? = null
    @SerializedName("100")
    @Expose
    var small: String? = null
    @SerializedName("115")
    @Expose
    var medium: String? = null
    @SerializedName("138")
    @Expose
    var large: String? = null
    @SerializedName("230")
    @Expose
    var xtraLarge: String? = null
    @SerializedName("276")
    @Expose
    var fullImage: String? = null
}