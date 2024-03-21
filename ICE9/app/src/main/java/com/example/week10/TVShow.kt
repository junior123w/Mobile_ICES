package com.example.week10

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TVShow(
    val title: String,
    val studio: String
)

