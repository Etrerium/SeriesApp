package com.example.myapplication.model

data class SerieResponse(
    val total: Int,
    val page: Int,
    val pages: Int,
    val tv_shows: List<Serie>
)

data class Serie(
    val id: Int,
    val name: String,
    val start_date: String?,
    val end_date: String?,
    val country: String?,
    val network: String?,
    val status: String?,
    val image_thumbnail_path: String
)