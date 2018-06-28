package com.abhinav.asthetic.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Copyright {
    @SerializedName("license")
    @Expose
    val license: String? = null
    @SerializedName("description")
    @Expose
    val description: String? = null
    @SerializedName("license_id")
    @Expose
    val licenseId: Int = 0
}