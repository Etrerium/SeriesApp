package com.example.myapplication.service

import com.example.myapplication.model.SerieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SerieApi {
    @GET("most-popular")
    suspend fun getPopularSeries(
        @Query("page") page: Int = 1
    ): Response<SerieResponse>
}