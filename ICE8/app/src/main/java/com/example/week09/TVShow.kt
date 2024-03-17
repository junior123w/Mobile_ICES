package com.example.week09

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TVShow(
    val title: String,
    val studio: String
)

