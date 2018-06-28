package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Site {
    @SerializedName("id")
    @Expose
    val id: Int = 0
    @SerializedName("parent_id")
    @Expose
    val parentId: Int = 0
    @SerializedName("name")
    @Expose
    val name: String? = null
    @SerializedName("key")
    @Expose
    val key: String? = null
    @SerializedName("icon")
    @Expose
    val icon: String? = null
    @SerializedName("app_icon")
    @Expose
    val appIcon: String? = null
    @SerializedName("domain")
    @Expose
    val domain: String? = null
    @SerializedName("url")
    @Expose
    val url: String? = null
    @SerializedName("ribbon")
    @Expose
    val ribbon: Ribbon? = null
}