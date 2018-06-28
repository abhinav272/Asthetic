package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Text {
    @SerializedName("title")
    @Expose
    val title: TextStyle? = null
    @SerializedName("subtitle")
    @Expose
    val subtitle: TextStyle? = null
    @SerializedName("paragraph")
    @Expose
    val paragraph: TextStyle? = null
    @SerializedName("caption")
    @Expose
    val caption: TextStyle? = null
    @SerializedName("link")
    @Expose
    val link: TextStyle? = null
}