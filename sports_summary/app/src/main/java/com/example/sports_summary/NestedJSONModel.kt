package com.example.sports_summary

import com.google.gson.annotations.SerializedName

data class NestedJSONModel (
    var data: List<Data>?


        )
data class Data(

    @SerializedName("home_name")
    val homeName: String?,

    @SerializedName("home_image")
    val homeImage: String?,
    @SerializedName("away_image")
    val awayImage: String?,
    @SerializedName("away_name")
    val awayName: String?,
    @SerializedName("season")
    val season: String?,
    @SerializedName("homeGoalCount")
    val homeGoalCount: Int?,
    @SerializedName("awayGoalCount")
    val awayGoalCount: Int?,
    @SerializedName("stadium_name")
    val stadiumName: String?


)
