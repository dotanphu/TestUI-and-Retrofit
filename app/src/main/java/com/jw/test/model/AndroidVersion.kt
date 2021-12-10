package com.jw.test.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AndroidVersion(
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("ver")
    val version: String,
    @Expose
    @SerializedName("api")
    val api: String
)
