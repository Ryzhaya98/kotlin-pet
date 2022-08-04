package com.example.kotlin_crypto


import com.google.gson.annotations.SerializedName

data class Test(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("message")
    val message: String,
    @SerializedName("metadata")
    val metadata: Metadata,
    @SerializedName("pager")
    val pager: Pager,
    @SerializedName("success")
    val success: Boolean
)