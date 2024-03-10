package com.example.week08
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TVShow(
    val title: String,
    val studio:String
)
