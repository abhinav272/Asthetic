package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ProjectModule {
    @SerializedName("id")
    @Expose
    val id: Int = 0
    @SerializedName("project_id")
    @Expose
    val projectId: Int = 0
    @SerializedName("type")
    @Expose
    val type: String? = null
    @SerializedName("full_bleed")
    @Expose
    val fullBleed: Int = 0
    @SerializedName("alignment")
    @Expose
    val alignment: String? = null
    @SerializedName("caption_alignment")
    @Expose
    val captionAlignment: String? = null
    @SerializedName("src")
    @Expose
    val src: String? = null
    @SerializedName("sizes")
    @Expose
    val sizes: ModuleSizes? = null
    @SerializedName("width")
    @Expose
    val width: Int = 0
    @SerializedName("height")
    @Expose
    val height: Int = 0
    @SerializedName("text")
    @Expose
    val text: String? = null
    @SerializedName("text_plain")
    @Expose
    val textPlain: String? = null
}