package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Ribbon {
    @SerializedName("image")
    @Expose
    val image: String? = null
    @SerializedName("image_2x")
    @Expose
    val image2x: String? = null
}