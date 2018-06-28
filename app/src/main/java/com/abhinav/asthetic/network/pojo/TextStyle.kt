package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class TextStyle {
    @SerializedName("font_family")
    @Expose
    val fontFamily: String? = null
    @SerializedName("font_weight")
    @Expose
    val fontWeight: String? = null
    @SerializedName("color")
    @Expose
    val color: String? = null
    @SerializedName("text_align")
    @Expose
    val textAlign: String? = null
    @SerializedName("line_height")
    @Expose
    val lineHeight: String? = null
    @SerializedName("font_size")
    @Expose
    val fontSize: String? = null
    @SerializedName("text_decoration")
    @Expose
    val textDecoration: String? = null
    @SerializedName("font_style")
    @Expose
    val fontStyle: String? = null
    @SerializedName("display")
    @Expose
    val display: String? = null
    @SerializedName("text_transform")
    @Expose
    val textTransform: String? = null
}