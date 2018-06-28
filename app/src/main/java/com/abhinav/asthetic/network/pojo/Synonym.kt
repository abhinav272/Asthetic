package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Synonym {
    @SerializedName("tag_id")
    @Expose
    val tagId: Int = 0
    @SerializedName("name")
    @Expose
    val name: String? = null
    @SerializedName("title")
    @Expose
    val title: String? = null
    @SerializedName("url")
    @Expose
    val url: String? = null
    @SerializedName("download_url")
    @Expose
    val downloadUrl: String? = null
    @SerializedName("gallery_url")
    @Expose
    val galleryUrl: String? = null
    @SerializedName("authenticated")
    @Expose
    val authenticated: Int = 0
    @SerializedName("type")
    @Expose
    val type: Int = 0
    @SerializedName("icon_url")
    @Expose
    val iconUrl: String? = null
    @SerializedName("icon_url_2x")
    @Expose
    val iconUrl2x: String? = null
}