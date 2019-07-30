package com.ShopBack.shopback.mvp.movies

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class MovieModel(@SerializedName("vote_count") val vote_count: Int,
                 @SerializedName("id") val id: Int,
                 @SerializedName("video") val video: Boolean,
                 @SerializedName("vote_average") val vote_average: Float ,
                 @SerializedName("title") val title: String ,
                 @SerializedName("popularity") val popularity:Float ,
                 @SerializedName("poster_path") val poster_path:String ,
                 @SerializedName("original_language") val original_language:String ,
                 @SerializedName("original_title") val original_title:String ,
                 @SerializedName("backdrop_path") val backdrop_path:String,
                 @SerializedName("overview") val overview:String,
                 @SerializedName("release_date") val release_date:String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        parcel.readFloat(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(vote_count)
        parcel.writeInt(id)
        parcel.writeByte(if (video) 1 else 0)
        parcel.writeFloat(vote_average)
        parcel.writeString(title)
        parcel.writeFloat(popularity)
        parcel.writeString(poster_path)
        parcel.writeString(original_language)
        parcel.writeString(original_title)
        parcel.writeString(backdrop_path)
        parcel.writeString(overview)
        parcel.writeString(release_date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieModel> {
        override fun createFromParcel(parcel: Parcel): MovieModel {
            return MovieModel(parcel)
        }

        override fun newArray(size: Int): Array<MovieModel?> {
            return arrayOfNulls(size)
        }
    }
}