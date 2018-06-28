package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Background {
    @SerializedName("color")
    @Expose
    var color: String? = null
    @SerializedName("image")
    @Expose
    var bgImage: BGImage? = null
}