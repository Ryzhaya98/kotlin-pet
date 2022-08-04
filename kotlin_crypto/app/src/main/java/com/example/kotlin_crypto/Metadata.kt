package com.example.kotlin_crypto


import com.google.gson.annotations.SerializedName

data class Metadata(
    @SerializedName("request_limit")
    val requestLimit: Any,
    @SerializedName("request_remaining")
    val requestRemaining: Any,
    @SerializedName("request_reset_message")
    val requestResetMessage: String
)