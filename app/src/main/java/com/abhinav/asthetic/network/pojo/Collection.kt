package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*


/**
 * Created by abhinav.sharma on 29/12/17.
 */
class Collection {

    var height: Int = 400
    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("user_id")
    @Expose
    var userId: Int = 0
    @SerializedName("public")
    @Expose
    var public: Int = 0
    @SerializedName("label")
    @Expose
    var label: String? = null
    @SerializedName("project_count")
    @Expose
    var projectCount: Int = 0
    @SerializedName("follower_count")
    @Expose
    var followerCount: Int = 0
    @SerializedName("admin_lock")
    @Expose
    var adminLock: Int = 0
    @SerializedName("data")
    @Expose
    var data: String? = null
    @SerializedName("created_on")
    @Expose
    var createdOn: Date? = null
    @SerializedName("updated_on")
    @Expose
    var updatedOn: Int = 0
    @SerializedName("modified_on")
    @Expose
    var modifiedOn: Int = 0
    @SerializedName("creator_id")
    @Expose
    var creatorId: Int = 0
    @SerializedName("owners")
    @Expose
    var owners: List<Owner>? = null
    @SerializedName("latest_projects")
    @Expose
    var latestProjects: List<LatestProject>? = null
    @SerializedName("stats")
    @Expose
    var stats: CollectionStats? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("privacy")
    @Expose
    var privacy: String? = null
    @SerializedName("project_covers")
    @Expose
    var projectCovers: List<CollectionCover>? = null
    @SerializedName("is_owner")
    @Expose
    var isIsOwner: Boolean = false
    @SerializedName("is_coowner")
    @Expose
    var isIsCoowner: Boolean = false
    @SerializedName("multiple_owners")
    @Expose
    var isMultipleOwners: Boolean = false
    @SerializedName("gallery_text")
    @Expose
    var galleryText: String? = null
    @SerializedName("show_lock")
    @Expose
    var isShowLock: Boolean = false

}