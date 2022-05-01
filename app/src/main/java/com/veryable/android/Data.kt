package com.veryable.android

import com.google.gson.annotations.SerializedName

data class Data (
    @SerializedName("id")
    val id: Int,
    @SerializedName("account_type")
    val account_type: String,
    @SerializedName("account_name")
    val account_name: String,
    @SerializedName("desc")
    val desc: String )




