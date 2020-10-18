package com.example.networkapplications.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Fact(
    @SerializedName("_v")
    val version: Int = 0,
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("upvotes")
    val upvotes: Int? = null,
    @SerializedName("type")
    val type: String? = null
) : Parcelable