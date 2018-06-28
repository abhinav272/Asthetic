package com.abhinav.asthetic.network.pojo

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by abhinav.sharma on 29/12/17.
 */
open class LatestProject() : Parcelable {

    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("published_on")
    @Expose
    var publishedOn: Int = 0
    @SerializedName("created_on")
    @Expose
    var createdOn: Int = 0
    @SerializedName("modified_on")
    @Expose
    var modifiedOn: Int = 0
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("privacy")
    @Expose
    var privacy: String? = null
    @SerializedName("fields")
    @Expose
    var fields: List<String>? = null
    @SerializedName("covers")
    @Expose
    var covers: LatestProjectCovers? = null
    @SerializedName("mature_content")
    @Expose
    var matureContent: Int = 0
    @SerializedName("mature_access")
    @Expose
    var matureAccess: String? = null
    @SerializedName("owners")
    @Expose
    var owners: List<Owner>? = null
    @SerializedName("stats")
    @Expose
    var stats: LatestProjectStats? = null
    @SerializedName("conceived_on")
    @Expose
    var conceivedOn: Int = 0

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        name = parcel.readString()
        publishedOn = parcel.readInt()
        createdOn = parcel.readInt()
        modifiedOn = parcel.readInt()
        url = parcel.readString()
        privacy = parcel.readString()
        fields = parcel.createStringArrayList()
        matureContent = parcel.readInt()
        matureAccess = parcel.readString()
        conceivedOn = parcel.readInt()
    }

    override fun equals(other: Any?): Boolean = when (other) {
        !is LatestProject -> false
        else -> id == other.id
    }

    override fun hashCode(): Int {
        return id
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeInt(publishedOn)
        parcel.writeInt(createdOn)
        parcel.writeInt(modifiedOn)
        parcel.writeString(url)
        parcel.writeString(privacy)
        parcel.writeStringList(fields)
        parcel.writeInt(matureContent)
        parcel.writeString(matureAccess)
        parcel.writeInt(conceivedOn)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LatestProject> {
        override fun createFromParcel(parcel: Parcel): LatestProject {
            return LatestProject(parcel)
        }

        override fun newArray(size: Int): Array<LatestProject?> {
            return arrayOfNulls(size)
        }
    }
}