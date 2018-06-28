package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Tool {
    @SerializedName("id")
    @Expose
    val id: Int = 0
    @SerializedName("title")
    @Expose
    val title: String? = null
    @SerializedName("category")
    @Expose
    val category: String? = null
    @SerializedName("category_label")
    @Expose
    val categoryLabel: String? = null
    @SerializedName("category_id")
    @Expose
    val categoryId: Int = 0
    @SerializedName("synonym")
    @Expose
    val synonym: Synonym? = null
    @SerializedName("approved")
    @Expose
    val approved: String? = null
    @SerializedName("url")
    @Expose
    val url: String? = null
}