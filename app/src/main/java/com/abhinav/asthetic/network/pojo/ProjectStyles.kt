package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class ProjectStyles {
    @SerializedName("text")
    @Expose
    val text: Text? = null
    @SerializedName("background")
    @Expose
    val background: Background? = null
}