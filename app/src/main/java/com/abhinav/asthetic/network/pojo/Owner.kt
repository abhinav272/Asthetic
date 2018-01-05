package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by abhinav.sharma on 29/12/17.
 */
class Owner {

    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("first_name")
    @Expose
    var firstName: String? = null
    @SerializedName("last_name")
    @Expose
    var lastName: String? = null
    @SerializedName("username")
    @Expose
    var username: String? = null
    @SerializedName("city")
    @Expose
    var city: String? = null
    @SerializedName("state")
    @Expose
    var state: String? = null
    @SerializedName("country")
    @Expose
    var country: String? = null
    @SerializedName("location")
    @Expose
    var location: String? = null
    @SerializedName("company")
    @Expose
    var company: String? = null
    @SerializedName("occupation")
    @Expose
    var occupation: String? = null
    @SerializedName("created_on")
    @Expose
    var createdOn: Int = 0
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("images")
    @Expose
    var images: OwnerImages? = null
    @SerializedName("display_name")
    @Expose
    var displayName: String? = null
    @SerializedName("fields")
    @Expose
    var fields: List<String>? = null
    @SerializedName("has_default_image")
    @Expose
    var hasDefaultImage: Int = 0
    @SerializedName("website")
    @Expose
    var website: String? = null
    @SerializedName("stats")
    @Expose
    var stats: OwnerStats? = null

}