package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProjectDetail : LatestProject() {
    @SerializedName("canvas_width")
    @Expose
    val canvasWidth: Int = 0
    @SerializedName("tags")
    @Expose
    val tags: List<String>? = null
    @SerializedName("description")
    @Expose
    val description: String? = null
    @SerializedName("editor_version")
    @Expose
    val editorVersion: Int = 0
    @SerializedName("allow_comments")
    @Expose
    val allowComments: Int = 0
    @SerializedName("modules")
    @Expose
    val modules: List<ProjectModule>? = null
    @SerializedName("short_url")
    @Expose
    val shortUrl: String? = null
    @SerializedName("copyright")
    @Expose
    val copyright: Copyright? = null
    @SerializedName("tools")
    @Expose
    val tools: List<Tool>? = null
    @SerializedName("features")
    @Expose
    val features: List<ProjectFeature>? = null
    @SerializedName("styles")
    @Expose
    val styles: ProjectStyles? = null
    @SerializedName("creator_id")
    @Expose
    val creatorId: Int = 0
}