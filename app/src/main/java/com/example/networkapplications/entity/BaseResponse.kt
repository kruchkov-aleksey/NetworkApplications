package com.example.networkapplications.entity

import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("all")
    var all: List<Fact>? = null
)